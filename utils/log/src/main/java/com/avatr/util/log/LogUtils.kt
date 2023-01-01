package com.avatr.util.log

import android.util.Log

object LogUtils {
    private const val TAG = "AvatrLog"

    fun logI(message: String) {
        Log.i(TAG, message)
    }

    fun logD(message: String) {
        Log.d(TAG, message)
    }
}