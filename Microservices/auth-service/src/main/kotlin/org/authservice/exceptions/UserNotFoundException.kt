package org.authservice.exceptions

class UserNotFoundException(override val message: String) : RuntimeException(message)