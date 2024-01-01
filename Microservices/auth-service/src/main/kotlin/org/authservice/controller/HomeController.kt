package org.authservice.controller

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/home")
class HomeController {

    @GetMapping("/normal")
    fun normalUser(): ResponseEntity<String> {
        return ResponseEntity.ok("Yes, I am normal user")
    }

    @GetMapping("/admin")
    fun adminUser(): ResponseEntity<String> {
        return ResponseEntity.ok("Yes, I am admin user")
    }

    @GetMapping("/public")
    fun publicUser(): ResponseEntity<String> {
        return ResponseEntity.ok("Yes, I am public user")
    }
}