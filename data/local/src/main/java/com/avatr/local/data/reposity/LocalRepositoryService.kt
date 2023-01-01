package com.avatr.local.data.reposity

import com.avatr.local.data.entites.BaiduEntity

interface LocalRepositoryService {
    suspend fun getBaiduContent(): String?
    suspend fun saveBaiduContent(baiduEntity: BaiduEntity)
}