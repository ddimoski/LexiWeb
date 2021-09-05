package com.finki.lexiweb.service

import com.finki.lexiweb.domain.Word
import com.finki.lexiweb.repository.WordRepository
import org.springframework.stereotype.Service

@Service
class WordService(private val wordRepository: WordRepository) {

    fun getById(id: Long) = wordRepository.getById(id)

    fun existsByName(name: String) = wordRepository.existsByName(name)

    fun getByName(name: String) = wordRepository.findByName(name)

    fun createWordByName(name: String): Word = if (wordRepository.existsByName(name)) {
        wordRepository.findByName(name)
    } else {
        Word(name = name)
    }
}