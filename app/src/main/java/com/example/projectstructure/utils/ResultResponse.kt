package com.example.projectstructure.utils

sealed class ResultResponse <T>(
    data: T? = null,
    exception: Exception? = null
) {
    data class Success <T>(val data: T) : ResultResponse<T>(data, null)

    data class Failed <T>(
        val exception: Exception
    ) : ResultResponse<T>(null, exception)

    // use to transform Result<T> to Result<R> when T -> R transform is possible
    inline fun <R> map(transform: (T) -> R): ResultResponse<R> {
        return when (this) {
            is Success -> try {
                Success(transform(data))
            } catch (e: Exception) {
                Failed(e)
            }
            is Failed -> Failed(exception)
        }
    }

}