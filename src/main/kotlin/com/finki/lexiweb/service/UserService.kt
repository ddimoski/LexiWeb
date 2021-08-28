package com.finki.lexiweb.service

import com.finki.lexiweb.repository.UserRepository
import org.springframework.stereotype.Service

@Service
class UserService (private val userRepository: UserRepository) {

    fun getById(id: Long) = userRepository.getById(id)
}