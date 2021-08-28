package com.finki.lexiweb.service

import com.finki.lexiweb.repository.WordRepository
import org.springframework.stereotype.Service

@Service
class WordService(private val wordRepository: WordRepository) {

    fun getById(id: Long) = wordRepository.getById(id)
}