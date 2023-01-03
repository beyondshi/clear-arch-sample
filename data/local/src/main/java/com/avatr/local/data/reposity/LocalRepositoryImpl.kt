package com.avatr.local.data.reposity

import com.avatr.local.data.db.BaiduEntityDao
import com.avatr.local.data.entites.BaiduEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.withContext

internal class LocalRepositoryImpl(
    private val baiduEntityDao: BaiduEntityDao,
) : LocalRepositoryService {
    private val serviceContext = Dispatchers.Default + SupervisorJob()

    override suspend fun getBaiduContent(): String? {
        return withContext(serviceContext) {
            val result = baiduEntityDao.getContent()?.content
            result
        }
    }

    override suspend fun saveBaiduContent(baiduEntity: BaiduEntity) {
        withContext(serviceContext) {
            baiduEntityDao.saveContent(baiduEntity)
        }
    }
}