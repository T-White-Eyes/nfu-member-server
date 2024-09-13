package com.nfu.member.exception.handler

import com.nfu.member.exception.ApiException
import com.nfu.member.exception.constant.ApiError
import com.nfu.member.exception.response.ApiErrorResponse
import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.HttpStatusCode
import org.springframework.http.ResponseEntity
import org.springframework.validation.BindingResult
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import org.springframework.web.context.request.WebRequest
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler

@RestControllerAdvice
class ApiExceptionHandler: ResponseEntityExceptionHandler() {

    @ExceptionHandler(ApiException::class)
    fun handle(ex: ApiException): ResponseEntity<Any> {
        return ResponseEntity(
            ApiErrorResponse(ex.apiError),
            HttpStatus.resolve(ex.status)!!
        )
    }

    override fun handleMethodArgumentNotValid(
        ex: MethodArgumentNotValidException,
        headers: HttpHeaders,
        status: HttpStatusCode,
        request: WebRequest
    ): ResponseEntity<Any> {
        val apiErrorResponse = makeApiErrorResponse(ex.bindingResult)
        return ResponseEntity(apiErrorResponse, HttpStatus.BAD_REQUEST)
    }

    private fun makeApiErrorResponse(bindingResult: BindingResult): ApiErrorResponse {
       var resultCode: String = ""
       var message: String? = ""

        if (bindingResult.hasErrors()) {
            message = bindingResult.fieldError?.defaultMessage
            val bindResultCode = bindingResult.fieldError?.code

            resultCode = when (bindResultCode) {
                NotNull::class.java.name -> ApiError.NOT_NULL.resultCode
                NotBlank::class.java.name -> ApiError.NOT_BLANK.resultCode
                Email::class.java.name -> ApiError.EMAIL.resultCode
                Size::class.java.name -> ApiError.SIZE.resultCode
                else -> ApiError.SERVER_ERROR.resultCode
            }
        }

        return ApiErrorResponse(resultCode = resultCode, message = message)
    }
}