package org.userservice.dao

import org.springframework.stereotype.Component
import org.userservice.dto.User
import org.userservice.exceptions.UserNotFoundException
import org.userservice.repository.UserRepository
import java.util.*

@Component
class UserDAO(val userRepository: UserRepository) {

    fun save(user: User): User {
//        user.addresses.forEach {
//            it.user = user
//        }
        return userRepository.save(user)
    }

    fun getAllUsers(): List<User> {
        return userRepository.findAll()
    }

    fun getUserByEmail(email: String): User {
        val existingUser: Optional<User> = userRepository.findByEmail(email)
        when {
            existingUser.isPresent -> {
                return existingUser.get()
            }

            else -> throw UserNotFoundException("User not found with Email : $email")
        }
    }

    fun update(email: String, user: User): User {
        val existingUser: User = getUserByEmail(email)

        existingUser.firstName = user.firstName
        existingUser.lastName = user.lastName
        existingUser.email = user.email
        existingUser.birthDate = user.birthDate

        return userRepository.save(existingUser)

    }
}