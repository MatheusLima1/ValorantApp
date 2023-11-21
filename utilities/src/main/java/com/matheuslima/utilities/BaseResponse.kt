package com.matheuslima.utilities

import com.matheuslima.utilities.exceptions.BaseException

sealed class BaseResponse<T> {
    class Loading<T> : BaseResponse<T>()
    data class Success<T>(val data: T) : BaseResponse<T>()
    data class Error<T>(val error: BaseException) : BaseResponse<T>()
}