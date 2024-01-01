package org.authservice.repository

import org.authservice.dto.UserCredentials
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface UserCredentialsRepository : JpaRepository<UserCredentials, Int> {
    fun findByEmail(email: String): Optional<UserCredentials>
}