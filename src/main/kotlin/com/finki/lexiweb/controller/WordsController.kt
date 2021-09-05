package com.finki.lexiweb.controller

import com.finki.lexiweb.service.WordService
import org.springframework.stereotype.Controller

@Controller
class WordsController(private val wordService: WordService) {
}