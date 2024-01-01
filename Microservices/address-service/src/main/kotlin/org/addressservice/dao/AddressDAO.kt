package org.addressservice.dao

import org.addressservice.dto.Address
import org.addressservice.exceptions.NoAddressFoundException
import org.addressservice.proxy.dao.UserProxyDAO
import org.addressservice.repository.AddressRepository
import org.springframework.stereotype.Component

@Component
class AddressDAO(val addressRepository: AddressRepository, val userProxyDAO: UserProxyDAO) {

    fun save(email: String, addresses: MutableList<Address>) {
        val user = userProxyDAO.getUserByEmail(email)
        if (user.statusCode.is2xxSuccessful) {
            addresses.forEach { it.userEmail = email }
            addressRepository.saveAll(addresses)
        }
    }

    fun getAddressesByUserEmail(email: String): List<Address> {
        val user = userProxyDAO.getUserByEmail(email)
        if (user.statusCode.is2xxSuccessful && addressRepository.findByUserEmail(email).isNotEmpty()) {
            return addressRepository.findByUserEmail(email)
        } else {
            throw NoAddressFoundException("No address(s) found for user-email : $email")
        }
    }
}