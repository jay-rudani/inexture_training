package org.apigateway.config

import org.apigateway.jwt.JwtAuthenticationFilter
import org.springframework.cloud.gateway.route.RouteLocator
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class RouteConfig(val jwtAuthenticationFilter: JwtAuthenticationFilter) {

    @Bean
    fun gatewayRouter(builder: RouteLocatorBuilder): RouteLocator {
        return builder
            .routes()
            .route { p ->
                p.path("/address/**").filters { filter -> filter.filter(jwtAuthenticationFilter) }
                    .uri("lb://address-service")
            }
            .route { p ->
                p.path("/user/**").filters { filter -> filter.filter(jwtAuthenticationFilter) }.uri("lb://user-service")
            }
            .route { p ->
                p.path("/auth/**", "/home/**").filters { filter -> filter.filter(jwtAuthenticationFilter) }
                    .uri("lb://auth-service")
            }
            .build()
    }
}