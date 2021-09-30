package com.finki.lexiweb.controller

import com.finki.lexiweb.domain.Test
import com.finki.lexiweb.dto.QuestionDTO
import com.finki.lexiweb.dto.TestDTO
import com.finki.lexiweb.service.TestService
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/test")
class TestController(private val testService: TestService) {

    @GetMapping("/{id}")
    fun getById(@PathVariable id: Long): TestDTO {
        val test = testService.getById(id)
        val questions = ArrayList<QuestionDTO>()
        test.questions.forEach { question ->
            val incorrectWords = ArrayList<String>()
            question.incorrectWords.forEach { incorrectWords.add(it.name) }
            val questionDto = QuestionDTO(
                question.id,
                question.mainWord.name,
                question.matchingWord.name,
                incorrectWords
            )
            questions.add(questionDto)
        }
        return TestDTO(test.id, test.name, questions)
    }

    @GetMapping("/all")
    fun getAll(): List<TestDTO> {
        val tests = ArrayList<TestDTO>()
        testService.getAll().forEach { test ->
            val questions = ArrayList<QuestionDTO>()
            test.questions.forEach { question ->
                val incorrectWords = ArrayList<String>()
                question.incorrectWords.forEach { incorrectWords.add(it.name) }
                val questionDto = QuestionDTO(
                    question.id,
                    question.mainWord.name,
                    question.matchingWord.name,
                    incorrectWords
                )
                questions.add(questionDto)
            }
            val testDTO = TestDTO(test.id, test.name, questions)
            tests.add(testDTO)
        }
        return tests
    }

    @PostMapping("/create")
    fun createTest(@RequestBody request: TestDTO): Long {
        val test = testService.createTest(request)
        return test.id
    }

}