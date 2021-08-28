package com.finki.lexiweb.service

import com.finki.lexiweb.repository.QuestionRepository
import org.springframework.stereotype.Service

@Service
class QuestionService(private val questionRepository: QuestionRepository) {

    fun getById(id: Long) = questionRepository.getById(id)
}