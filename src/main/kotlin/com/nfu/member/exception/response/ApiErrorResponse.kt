package com.nfu.member.exception.response

import com.nfu.member.exception.constant.ApiError

class ApiErrorResponse(
    val resultCode: String,
    val message: String?,
) {

    constructor(apiError: ApiError): this(apiError.resultCode, apiError.message)
}