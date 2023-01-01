package com.avatr.remote.data.repository

import com.avatr.remote.data.api.RemoteBffApi
import com.avatr.remote.data.base.BffResult
import com.avatr.remote.data.base.RemoteRepositoryResult
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.withContext

internal class RemoteDataStoreImpl(
    private val remoteBffApi: RemoteBffApi,
) : RemoteRepositoryService {
    private val serviceContext = Dispatchers.Default + SupervisorJob()

    override suspend fun getBaiduContent(): RemoteRepositoryResult<String> {
        return withContext(serviceContext) {
            when (val result = remoteBffApi.getBaidu()) {
                is BffResult.Failure -> {
                    RemoteRepositoryResult.Error()
                }

                is BffResult.Success -> {
                    RemoteRepositoryResult.Success(result.response)
                }
            }
        }
    }
}