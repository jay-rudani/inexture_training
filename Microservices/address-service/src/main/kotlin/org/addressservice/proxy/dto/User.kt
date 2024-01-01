package org.addressservice.proxy.dto

import java.util.*

data class User(
    var id: Int,
    var firstName: String,
    var lastName: String,
    var email: String,
    var birthDate: Date,
)
