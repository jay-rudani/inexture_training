package org.addressservice.repository

import org.addressservice.dto.Address
import org.springframework.data.jpa.repository.JpaRepository

interface AddressRepository : JpaRepository<Address, Int> {

    fun findByUserEmail(email: String): List<Address>
}