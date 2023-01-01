package com.avatr.business1

internal sealed class ClickEventState {
    object GetBaiduContent : ClickEventState()
}

internal sealed class BaiduViewState {
    object Loading : BaiduViewState()
    object Default : BaiduViewState()
    object Error : BaiduViewState()
    data class Success(val content: String?) : BaiduViewState()
}
