package org.userservice.controller

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.userservice.dao.UserDAO
import org.userservice.dto.User

@RestController
@RequestMapping("/user")
class UserController(val userDAO: UserDAO) {

    @PostMapping("/save")
    fun save(@RequestBody user: User): ResponseEntity<User> {
        return ResponseEntity(userDAO.save(user), HttpStatus.CREATED)
    }

    @GetMapping("/get/all")
    fun getAllUsers(): ResponseEntity<List<User>> {
        return ResponseEntity(userDAO.getAllUsers(), HttpStatus.FOUND)
    }

    @GetMapping("/get/email/{email}")
    fun getUserByEmail(@PathVariable email: String): ResponseEntity<User> {
        return ResponseEntity(userDAO.getUserByEmail(email), HttpStatus.OK)
    }

    @PutMapping("/update/{email}")
    fun update(@PathVariable email: String, @RequestBody user: User): ResponseEntity<User> {
        return ResponseEntity(userDAO.update(email, user), HttpStatus.ACCEPTED)
    }
}