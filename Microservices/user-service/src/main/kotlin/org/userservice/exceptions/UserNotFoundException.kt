package org.userservice.exceptions

class UserNotFoundException(override val message: String) : RuntimeException(message)