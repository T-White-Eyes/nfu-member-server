package com.nfu.member.exception

import com.nfu.member.exception.constant.ApiError

open class ApiException(apiError: ApiError): RuntimeException() {

    val status = apiError.status
    val resultCode: String = apiError.resultCode
    val apiError: ApiError = apiError
}