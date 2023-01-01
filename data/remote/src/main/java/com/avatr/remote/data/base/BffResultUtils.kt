package com.avatr.remote.data.base

import io.ktor.serialization.JsonConvertException
import kotlinx.serialization.SerializationException

/**
 * Runs the [block] or returns the specific [BffResult.Failure]. At
 * this level this is either [BffResult.Failure.SerializationError] or [BffResult.Failure.NetworkError].
 */
@Suppress("UNCHECKED_CAST")
internal inline fun <T> runCatchingOrError(block: () -> BffResult<T>): BffResult<T> =
    runCatching { block() }.getOrElse {
        when (it) {
            is SerializationException, is JsonConvertException -> BffResult.Failure.SerializationError(it)
            else -> BffResult.Failure.NetworkError(it)
        }
    }
