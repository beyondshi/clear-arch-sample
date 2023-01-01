package com.avatr.business1

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.avatr.data.common.api.RepositoryResult
import com.avatr.data.common.api.RepositoryService
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class BaiduViewModule(
    private val repositoryService: RepositoryService,
) : ViewModel() {

    private val _baiduFlow: MutableStateFlow<BaiduViewState> = MutableStateFlow(BaiduViewState.Default)

    internal val baiduFlow = _baiduFlow.asStateFlow()

    internal fun clickEvent(clickEventState: ClickEventState){
        when(clickEventState){
            ClickEventState.GetBaiduContent -> {
                getBaiduContent()
            }
        }
    }

    private fun getBaiduContent() {
        viewModelScope.launch {
            _baiduFlow.value = BaiduViewState.Loading
            when (val result = repositoryService.getBaiduContent()) {
                is RepositoryResult.Error -> {
                    _baiduFlow.value = BaiduViewState.Error
                }

                is RepositoryResult.Success -> {
                    _baiduFlow.value = BaiduViewState.Success(result.data)
                }
            }
        }
    }
}