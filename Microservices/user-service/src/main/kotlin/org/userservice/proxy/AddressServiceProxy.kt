package org.userservice.proxy

import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.userservice.dto.Address

@FeignClient(name = "address-service")
interface AddressServiceProxy {

    @PostMapping("/address/save/{email}")
    fun save(@PathVariable email: String, @RequestBody addresses: MutableList<Address>)
}