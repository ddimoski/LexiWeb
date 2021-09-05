package com.finki.lexiweb.service

import com.finki.lexiweb.domain.Question
import com.finki.lexiweb.domain.Test
import com.finki.lexiweb.domain.Word
import com.finki.lexiweb.dto.TestDTO
import com.finki.lexiweb.repository.TestRepository
import org.springframework.stereotype.Service

@Service
class TestService(
    private val testRepository: TestRepository,
    private val wordService: WordService
) {

    fun getById(id: Long): Test = testRepository.getById(id)

    fun getAll(): List<Test> = testRepository.findAll()

    fun createTest(request: TestDTO): Test {
        val questions = ArrayList<Question>()
        request.questions.forEach { question ->
            val incorrectWords = ArrayList<Word>()
            question.incorrectWords.forEach { incorrectWord ->
                val word: Word = wordService.createWordByName(incorrectWord)
                incorrectWords.add(word)
                val mainWord = wordService.createWordByName(question.mainWord)
                val matchingWord = wordService.createWordByName(question.matchingWord)
                val newQuestion = Question(mainWord, matchingWord, incorrectWords)
                questions.add(newQuestion)
            }
        }
        return Test(request.name, questions)
    }
}