package com.avatr.data.common.api

interface RepositoryService {
    suspend fun getBaiduContent(): RepositoryResult<String>
}