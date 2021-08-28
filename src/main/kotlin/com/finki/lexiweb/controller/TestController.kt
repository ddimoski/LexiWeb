package com.finki.lexiweb.controller

import com.finki.lexiweb.service.TestService
import org.springframework.stereotype.Controller

@Controller
class TestController(private val testService: TestService) {
}