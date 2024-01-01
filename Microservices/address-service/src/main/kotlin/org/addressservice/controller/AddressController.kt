package org.addressservice.controller

import org.addressservice.dao.AddressDAO
import org.addressservice.dto.Address
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/address")
class AddressController(val addressDAO: AddressDAO) {

    @PostMapping("/save/{email}")
    fun save(@PathVariable email: String, @RequestBody addresses: MutableList<Address>) {
        ResponseEntity(addressDAO.save(email, addresses), HttpStatus.CREATED)
    }

    @GetMapping("/get/email/{email}")
    fun getAddressesByUserEmail(@PathVariable email: String): ResponseEntity<List<Address>> {
        return ResponseEntity(addressDAO.getAddressesByUserEmail(email), HttpStatus.OK)
    }
}