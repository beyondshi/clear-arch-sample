package com.avatr.util.ui

import android.app.Activity
import android.content.Intent
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

inline fun <T> Flow<T>.collectWhile(
    lifecycleOwner: LifecycleOwner,
    lifecycleState: Lifecycle.State,
    crossinline action: suspend (T) -> Unit,
) {
    lifecycleOwner.launchWhile(lifecycleState) {
        collect { action(it) }
    }
}

inline fun <T> Flow<T>.collectForView(
    fragment: Fragment,
    crossinline action: suspend (T) -> Unit,
) = fragment.viewLifecycleOwner.lifecycleScope.launchWhenCreated {
    collect { action(it) }
}

inline fun <T> Flow<T>.collectLatestWhile(
    lifecycleOwner: LifecycleOwner,
    lifecycleState: Lifecycle.State,
    crossinline action: suspend (T) -> Unit,
) {
    lifecycleOwner.launchWhile(lifecycleState) {
        collectLatest { action(it) }
    }
}

/**
 * 生命周期方法中监听数据变化
 */
inline fun LifecycleOwner.launchWhile(
    lifecycleState: Lifecycle.State,
    crossinline block: suspend CoroutineScope.() -> Unit,
) {
    lifecycleScope.launch {
        this@launchWhile.repeatOnLifecycle(lifecycleState) {
            block()
        }
    }
}
