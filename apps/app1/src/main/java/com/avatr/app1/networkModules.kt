package com.avatr.app1

import com.avatr.core.network.ConnectBff
import org.koin.dsl.module

val connectBffModule = module {
    single {
        ConnectBff(
            when (BuildConfig.DEBUG) {
                true -> "https://www.baidu.com"
                false -> "https://www.baidu.com"
            }
        )
    }
}