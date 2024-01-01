package org.apigateway.exception

class JwtTokenNotValidException(override val message: String) : RuntimeException(message)