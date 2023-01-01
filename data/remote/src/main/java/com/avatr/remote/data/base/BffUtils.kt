package com.avatr.remote.data.base

import com.avatr.remote.data.api.RemoteBffApi
import io.ktor.client.call.NoTransformationFoundException
import io.ktor.client.call.body
import io.ktor.client.request.HttpRequestBuilder
import io.ktor.client.request.parameter
import io.ktor.client.statement.HttpResponse
import io.ktor.client.statement.readBytes
import io.ktor.http.isSuccess
import kotlinx.serialization.SerializationException
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import org.slf4j.LoggerFactory


private val json = Json {
    ignoreUnknownKeys = true
}

private val log = LoggerFactory.getLogger(RemoteBffApi::class.java)

private fun BffResult<*>.log() = when (this) {
    is BffResult.Success -> log.info("China Charge API ${this.response}")
    else -> log.warn("China Charge API $this")
}

/**
 * Receives the [HttpResponse] and parses it to the specific [SmamoBffResult]
 * with the correct [Type]. It takes two generics: First the [DTO] type
 * which is received from the Charge BFF and the actual result [Type].
 *
 * @param map The function to map the [DTO] objects to the actual [Type] objects.
 */
@Suppress("UNCHECKED_CAST")
internal suspend inline fun <reified DTO> receiveBffResult(
    block: () -> HttpResponse,
): BffResult<DTO> = runCatchingOrError<DTO> {
    val response = block()
    return if (response.status.isSuccess()) {
        // Try to parse the response
        try {
            BffResult.Success(response.body())
        } catch (e: NoTransformationFoundException) {
            BffResult.Failure.SerializationError(e)
        }
    } else {
        try {
            BffResult.Failure.LocalizedError(json.decodeFromString(String(response.readBytes())))
        } catch (e: SerializationException) {
            BffResult.Failure.HttpError(response.status)
        }
    }
}.apply {
    this.log()
}

internal fun HttpRequestBuilder.addQueryParameters(vararg param: Pair<String, Any?>) {
    for ((key, value) in param) {
        parameter(key, value)
    }
}
