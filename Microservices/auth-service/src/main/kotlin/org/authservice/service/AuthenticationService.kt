package org.authservice.service

import org.authservice.auth.AuthenticationRequest
import org.authservice.auth.AuthenticationResponse
import org.authservice.auth.RegisterRequest
import org.authservice.dto.UserCredentials
import org.authservice.enums.Role
import org.authservice.repository.UserCredentialsRepository
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import java.util.*

@Service
class AuthenticationService(
    val userCredentialsRepository: UserCredentialsRepository,
    val passwordEncoder: PasswordEncoder,
    val jwtService: JwtService,
    val authenticationManager: AuthenticationManager
) {

    fun register(request: RegisterRequest): AuthenticationResponse {
        val user = UserCredentials.Builder()
            .email(request.email)
            .password(passwordEncoder.encode(request.password))
            .role(Role.USER)
            .createdAt(Date())
            .build()
        userCredentialsRepository.save(user)
        val jwtToken = jwtService.generateToken(user)
        return AuthenticationResponse.Builder()
            .token(jwtToken)
            .build()
    }

    fun authenticate(request: AuthenticationRequest): AuthenticationResponse {
        authenticationManager.authenticate(
            UsernamePasswordAuthenticationToken(
                request.email,
                request.password
            )
        )
        val user = userCredentialsRepository.findByEmail(request.email)
            .orElseThrow { UsernameNotFoundException("User not found with email : ${request.email}") }
        val jwtToken = jwtService.generateToken(user)
        return AuthenticationResponse.Builder()
            .token(jwtToken)
            .build()
    }
}
