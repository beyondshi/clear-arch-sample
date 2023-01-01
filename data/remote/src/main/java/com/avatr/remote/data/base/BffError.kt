package com.avatr.remote.data.base

import kotlinx.serialization.Serializable

@Serializable
data class BffError(
    val code: Int,
    val message: String,
    val data: String?,
)
