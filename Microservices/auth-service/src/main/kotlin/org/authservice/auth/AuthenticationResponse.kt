package org.authservice.auth

data class AuthenticationResponse(var token: String) {
    data class Builder(var token: String = "") {
        fun token(token: String) = apply { this.token = token }
        fun build() = AuthenticationResponse(token)
    }
}
