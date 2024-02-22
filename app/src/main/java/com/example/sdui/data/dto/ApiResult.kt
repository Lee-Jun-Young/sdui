package com.example.sdui.data.dto


sealed class ApiResult<out T> {
    data class Success<out T>(val data: T) : ApiResult<T>()
    data class Error(val errorMsg: String? = null) :
        ApiResult<Nothing>()
}