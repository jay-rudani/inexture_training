package org.addressservice.exceptions.handler

import org.addressservice.exceptions.NoAddressFoundException
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class ExceptionHandler {

    @ExceptionHandler(NoAddressFoundException::class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    fun handleNoAddressFoundException(ex: NoAddressFoundException): String {
        return ex.message
    }
}