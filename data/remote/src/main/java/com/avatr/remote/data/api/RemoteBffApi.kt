package com.avatr.remote.data.api

import com.avatr.remote.data.base.BASE_PATH
import com.avatr.remote.data.base.BffResult
import com.avatr.remote.data.base.addQueryParameters
import com.avatr.remote.data.base.receiveBffResult
import io.ktor.client.HttpClient
import io.ktor.client.request.get

class RemoteBffApi(private val httpClient: HttpClient) {

    suspend fun getBaidu(): BffResult<String> = receiveBffResult {
        httpClient.get(BASE_PATH + "") {
            addQueryParameters()
        }
    }
}
