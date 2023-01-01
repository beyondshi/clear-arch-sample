package com.avatr.remote.data

import androidx.core.os.LocaleListCompat
import com.avatr.core.network.ConnectBff
import com.avatr.remote.data.api.RemoteBffApi
import com.avatr.remote.data.repository.RemoteDataStoreImpl
import com.avatr.remote.data.repository.RemoteRepositoryService
import com.chuckerteam.chucker.api.ChuckerInterceptor
import io.ktor.client.HttpClient
import io.ktor.client.engine.okhttp.OkHttp
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.request.header
import io.ktor.http.HttpHeaders
import io.ktor.serialization.kotlinx.json.json
import java.io.File
import java.util.Locale
import java.util.concurrent.TimeUnit
import kotlinx.serialization.json.Json
import okhttp3.Cache
import okhttp3.ConnectionSpec
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.bind
import org.koin.dsl.module
import org.slf4j.LoggerFactory

private const val TIMEOUT = 70_000L
private const val MAX_CACHE_SIZE = (1024 * 1024 * 2).toLong()

private val remoteModules = module {
    single {
        HttpClient(OkHttp) {// Ktor
            defaultRequest {
                url(get<ConnectBff>().baseUrl)
                header(HttpHeaders.AcceptLanguage, LocaleListCompat.getDefault()[0]?.language ?: Locale.CHINESE)
                header(HttpHeaders.ContentType, "application/json; charset=utf-8")
            }
            engine {
                addInterceptor(ChuckerInterceptor.Builder(androidContext()).build())
                config {
                    connectTimeout(TIMEOUT, TimeUnit.SECONDS)
                    readTimeout(TIMEOUT, TimeUnit.SECONDS)
                    writeTimeout(TIMEOUT, TimeUnit.SECONDS)
                    cache(Cache(File(androidContext().cacheDir, "ktor-client"), MAX_CACHE_SIZE))
                    connectionSpecs(listOf(ConnectionSpec.RESTRICTED_TLS))
                }
            }
            install(ContentNegotiation) {
                json(Json {
                    ignoreUnknownKeys = true
                    encodeDefaults = true
                    isLenient = true
                })
            }
            Logging {
                logger = object : Logger {
                    private val delegate = LoggerFactory.getLogger(HttpClient::class.java)
                    override fun log(message: String) = delegate.debug(message)
                }
                level = LogLevel.ALL
            }
        }
    }

    single {
        RemoteBffApi(get())
    }
}

private val apiModules = module {
    single<RemoteRepositoryService> { RemoteDataStoreImpl(get()) } bind RemoteRepositoryService::class
}

val remoteModuleList = remoteModules + apiModules