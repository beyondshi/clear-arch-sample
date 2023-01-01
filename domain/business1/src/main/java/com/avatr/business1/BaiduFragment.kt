package com.avatr.business1

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import com.avatr.business1.databinding.Business1BaiduFragmentBinding
import com.avatr.util.ui.collectWhile
import org.koin.androidx.viewmodel.ext.android.viewModel

class BaiduFragment : Fragment() {

    private var _binding: Business1BaiduFragmentBinding? = null
    private val binding get() = _binding!!
    private val baiduViewModule: BaiduViewModule by viewModel()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = Business1BaiduFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.business1BtnGetBaidu.setOnClickListener {
            baiduViewModule.clickEvent(ClickEventState.GetBaiduContent)
        }

        baiduViewModule.baiduFlow.collectWhile(this, Lifecycle.State.RESUMED) {
            when (it) {
                BaiduViewState.Default -> Unit
                BaiduViewState.Error -> binding.content.text = "内容加载错误"
                BaiduViewState.Loading -> binding.content.text = "内容加载中......"
                is BaiduViewState.Success -> binding.content.text = it.content
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}