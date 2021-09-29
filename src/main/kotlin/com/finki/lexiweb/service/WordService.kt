package com.finki.lexiweb.service

import com.finki.lexiweb.domain.Word
import com.finki.lexiweb.repository.WordRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import java.lang.RuntimeException
import java.util.stream.LongStream.range
import kotlin.random.Random

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

    fun getTenRandomWords(): List<Word> {
        val wordCount = wordRepository.count()
        val listOfWords = ArrayList<Word>()
        var numberOfWords = 10L
        if (wordCount == 0L) {
            throw RuntimeException("Нема доволно зборови во базата за да се изврши оваа активност")
        }
        if (wordCount < 10) {
            numberOfWords = wordCount
        }
        range(0, numberOfWords).forEach {
            val randomNumber = Random(wordCount-1)
            val randomWord: Word? = wordRepository.findByIdOrNull(randomNumber.nextLong())
            if (randomWord != null && !listOfWords.contains(randomWord)) {
                listOfWords.add(randomWord)
            }
        }
        return listOfWords;
    }
}