package com.finki.lexiweb.service

import com.finki.lexiweb.repository.TestRepository
import org.springframework.stereotype.Service

@Service
class TestService(private val testRepository: TestRepository) {

    fun getById(id: Long) = testRepository.getById(id)
}