package org.authservice.filter

import jakarta.servlet.FilterChain
import jakarta.servlet.ServletException
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.authservice.service.JwtService
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource
import org.springframework.stereotype.Component
import org.springframework.web.filter.OncePerRequestFilter
import java.io.IOException

@Component
class JwtAuthenticationFilter(val jwtService: JwtService, val userDetailsService: UserDetailsService) :
    OncePerRequestFilter() {

    @Throws(ServletException::class, IOException::class)
    override fun doFilterInternal(
        request: HttpServletRequest,
        response: HttpServletResponse,
        filterChain: FilterChain
    ) {
        val authHeader: String? = request.getHeader("Authorization")
        val userEmail: String

        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            filterChain.doFilter(request, response)
            return
        }


        val jwt = authHeader.substring(7)
        userEmail = jwtService.extractUsername(jwt)
        if (userEmail != null && SecurityContextHolder.getContext().authentication == null) {
            val userDetails: UserDetails = userDetailsService.loadUserByUsername(userEmail)
            if (jwtService.isTokenValid(jwt, userDetails)) {
                val authToken = UsernamePasswordAuthenticationToken(
                    userDetails,
                    null,
                    userDetails.authorities
                )
                authToken.details = WebAuthenticationDetailsSource().buildDetails(request)
                SecurityContextHolder.getContext().authentication = authToken
            }
        }
        filterChain.doFilter(request, response)
    }
}
