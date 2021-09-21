package com.finki.lexiweb.dto

class JwtDTO(val token: String,
             val id: Long,
             val username: String,
             val email: String,
             val roles: String,
             val type: String = "Bearer")