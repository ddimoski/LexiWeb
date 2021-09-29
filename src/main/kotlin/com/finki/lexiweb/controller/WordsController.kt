package com.finki.lexiweb.controller

import com.finki.lexiweb.service.WordService
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/api/words")
class WordsController(private val wordService: WordService) {

    @GetMapping("/random-10")
    fun getTenRandomWords() = wordService.getTenRandomWords()

}