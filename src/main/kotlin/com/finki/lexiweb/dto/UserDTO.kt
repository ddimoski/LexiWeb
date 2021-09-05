package com.finki.lexiweb.dto

import java.time.ZonedDateTime

class UserDTO(
    val id: Long?,
    val username: String,
    val password: String,
    val email: String?,
    val firstName: String?,
    val lastName: String?,
    val dateOfBirth: ZonedDateTime?
)