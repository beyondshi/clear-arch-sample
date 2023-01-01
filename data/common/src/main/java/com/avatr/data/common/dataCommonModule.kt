package com.avatr.data.common

import com.avatr.data.common.api.RepositoryService
import com.avatr.data.common.api.RepositoryServiceImpl
import org.koin.dsl.bind
import org.koin.dsl.module

val dataCommonModule = module {
    single<RepositoryService> { RepositoryServiceImpl(get(), get()) } bind RepositoryService::class
}