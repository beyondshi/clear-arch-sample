package com.avatr.data.common.api

import com.avatr.local.data.entites.BaiduEntity
import com.avatr.local.data.reposity.LocalRepositoryService
import com.avatr.remote.data.base.RemoteRepositoryResult
import com.avatr.remote.data.repository.RemoteRepositoryService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.withContext

class RepositoryServiceImpl(
    private val localRepositoryService: LocalRepositoryService,
    private val remoteRepositoryService: RemoteRepositoryService,
) : RepositoryService {
    private val serviceContext = Dispatchers.Default + SupervisorJob()

    override suspend fun getBaiduContent(): RepositoryResult<String> {
        return withContext(serviceContext) {
            val localResult = localRepositoryService.getBaiduContent()
            if (localResult.isNullOrEmpty()) {
                when (val remoteResult = remoteRepositoryService.getBaiduContent()) {
                    is RemoteRepositoryResult.Success -> {
                        localRepositoryService.saveBaiduContent(BaiduEntity(content = remoteResult.data))
                        RepositoryResult.Success(remoteResult.data)
                    }

                    is RemoteRepositoryResult.Error -> RepositoryResult.Error()
                }
            } else {
                RepositoryResult.Success(localResult)
            }
        }
    }
}