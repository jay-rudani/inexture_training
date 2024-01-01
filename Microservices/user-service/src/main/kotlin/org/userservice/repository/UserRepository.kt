package org.userservice.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.userservice.dto.User
import java.util.*

interface UserRepository : JpaRepository<User, Int> {
    fun findByEmail(email: String): Optional<User>
}