package com.avatr.app1

import android.app.Application
import com.avatr.business1.business1Module
import com.avatr.data.common.dataCommonModule
import com.avatr.local.data.localDataModules
import com.avatr.remote.data.remoteModuleList
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        loadKoin()
    }

    private fun loadKoin() {
        startKoin {
            androidContext(this@App)
            modules(
                connectBffModule,
                *remoteModuleList.toTypedArray(),
                business1Module,
                localDataModules,
                dataCommonModule,
            )
        }
    }
}