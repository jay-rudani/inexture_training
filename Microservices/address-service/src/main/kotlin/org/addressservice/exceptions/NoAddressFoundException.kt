package org.addressservice.exceptions

class NoAddressFoundException(override val message: String) : RuntimeException(message)