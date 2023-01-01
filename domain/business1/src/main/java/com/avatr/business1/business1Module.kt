package com.avatr.business1

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val business1Module = module {
    viewModel {
        BaiduViewModule(get())
    }
}