package org.addressservice.proxy

import org.addressservice.proxy.dto.User
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable

@FeignClient(name = "user-service", url = "localhost:8100")
interface UserServiceProxy {

    @GetMapping("user/get/email/{email}")
    fun getUserByEmail(@PathVariable email: String): ResponseEntity<User>
}