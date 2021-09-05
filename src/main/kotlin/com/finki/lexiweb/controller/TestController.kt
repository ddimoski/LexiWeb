package com.finki.lexiweb.controller

import com.finki.lexiweb.domain.Test
import com.finki.lexiweb.dto.TestDTO
import com.finki.lexiweb.service.TestService
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*

@Controller
@RequestMapping("/api/test")
class TestController(private val testService: TestService) {

    @GetMapping("/{id}")
    fun getById(@PathVariable id: Long) = testService.getById(id)

    @GetMapping("/all")
    fun getAll() = testService.getAll()

    @PostMapping("/create")
    fun createTest(@RequestBody request: TestDTO): Long  {
        val test = testService.createTest(request)
        return test.id
    }

}