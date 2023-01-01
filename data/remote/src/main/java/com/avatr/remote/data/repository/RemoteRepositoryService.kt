package com.avatr.remote.data.repository

import com.avatr.remote.data.base.RemoteRepositoryResult

interface RemoteRepositoryService {
    suspend fun getBaiduContent(): RemoteRepositoryResult<String>
}