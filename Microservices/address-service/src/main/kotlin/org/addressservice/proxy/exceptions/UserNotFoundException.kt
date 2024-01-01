package org.addressservice.proxy.exceptions

class UserNotFoundException(override val message: String) : RuntimeException(message)