package com.avatr.local.data

import com.avatr.local.data.db.LocalDatabase
import com.avatr.local.data.reposity.LocalDataStoreImpl
import com.avatr.local.data.reposity.LocalRepositoryService
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.bind
import org.koin.dsl.module

val localDataModules = module {
    single {
        LocalDatabase.getInstance(androidContext()).getBaiduDao()
    }

    single<LocalRepositoryService> { LocalDataStoreImpl(get()) } bind LocalRepositoryService::class
}