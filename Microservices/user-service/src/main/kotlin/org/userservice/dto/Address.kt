package org.userservice.dto

data class Address(
    var id: Int,
    var addressLine1: String,
    var addressLine2: String,
    var city: String,
    var state: String,
    var country: String,
    var userEmail: String
)
