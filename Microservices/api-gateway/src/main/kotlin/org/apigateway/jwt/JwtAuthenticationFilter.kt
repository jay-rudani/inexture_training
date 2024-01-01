package org.apigateway.jwt

import org.apigateway.exception.JwtTokenNotValidException
import org.springframework.cloud.gateway.filter.GatewayFilter
import org.springframework.cloud.gateway.filter.GatewayFilterChain
import org.springframework.http.HttpStatus
import org.springframework.http.server.reactive.ServerHttpRequest
import org.springframework.http.server.reactive.ServerHttpResponse
import org.springframework.stereotype.Component
import org.springframework.web.server.ServerWebExchange
import reactor.core.publisher.Mono
import java.util.function.Predicate


@Component
class JwtAuthenticationFilter(val jwtService: JwtService) : GatewayFilter {

    override fun filter(exchange: ServerWebExchange, chain: GatewayFilterChain): Mono<Void> {
        val request: ServerHttpRequest = exchange.request

        val apiEndpoints = listOf("/register", "/authenticate")

        val isApiSecured: Predicate<ServerHttpRequest> = Predicate<ServerHttpRequest> { r ->
            apiEndpoints.stream()
                .noneMatch { uri: String ->
                    r.uri.path.contains(uri)
                }
        }

        if (isApiSecured.test(request)) {
            if (!request.headers.containsKey("Authorization")) {
                val response: ServerHttpResponse = exchange.response
                response.setStatusCode(HttpStatus.UNAUTHORIZED)

                return response.setComplete()
            }

            var token: String = request.headers.getOrEmpty("Authorization")[0]
            token = token.substring(7)
            if (!jwtService.isTokenValid(token)) {
                throw JwtTokenNotValidException("Token not valid!")
            }
        }

        return chain.filter(exchange)
    }
}