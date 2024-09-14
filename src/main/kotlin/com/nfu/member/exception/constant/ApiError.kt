package com.nfu.member.exception.constant

import org.springframework.http.HttpStatus

enum class ApiError(
    val status: Int,
    val resultCode: String,
    val message: String
) {

    SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR.value(), "-1", "Server Error"),
    NOT_NULL(HttpStatus.BAD_REQUEST.value(), "-2", "Not Null"),
    NOT_BLANK(HttpStatus.BAD_REQUEST.value(), "-3", "Not Blank"),
    EMAIL(HttpStatus.BAD_REQUEST.value(), "-4", "Email Format check"),
    SIZE(HttpStatus.BAD_REQUEST.value(), "-5", "size check"),

   INVALID_EMAIL(HttpStatus.BAD_REQUEST.value(), "-100", "Invalid Email"),
   INVALID_NICKNAME(HttpStatus.BAD_REQUEST.value(), "-101", "Invalid Nickname"),
   INVALID_PASSWORD(HttpStatus.BAD_REQUEST.value(), "-102", "Invalid Password"),
   INVALID_AUTH_PLATFORM_ID(HttpStatus.BAD_REQUEST.value(), "-103", "Invalid Auth Platform Id"),

    ALREADY_EXISTS_EMAIL(HttpStatus.BAD_REQUEST.value(), "-104", "Already Exists Email"),
    ALREADY_EXISTS_NICKNAME(HttpStatus.BAD_REQUEST.value(), "-105", "Already Exists Nickname"),
    ALREADY_EXISTS_AUTH_PLATFORM_ID(HttpStatus.BAD_REQUEST.value(), "-106", "Already Exists Auth Platform Id"),

    NOT_FOUND_MEMBER(HttpStatus.NOT_FOUND.value(), "-107", "Not Found Member"),
   ;
}