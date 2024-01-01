package org.addressservice.proxy.dao

import feign.FeignException
import org.addressservice.proxy.UserServiceProxy
import org.addressservice.proxy.dto.User
import org.addressservice.proxy.exceptions.UserNotFoundException
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service

@Service
class UserProxyDAO(val userServiceProxy: UserServiceProxy) {

    fun getUserByEmail(email: String): ResponseEntity<User> {
        try {
            return userServiceProxy.getUserByEmail(email)
        } catch (ex: FeignException.NotFound) {
            throw UserNotFoundException("User not found with Email : $email")
        }
    }
}