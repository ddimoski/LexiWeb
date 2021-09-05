package com.finki.lexiweb.dto

class QuestionDTO(
    val id: Long?,
    val mainWord: String,
    val matchingWord: String,
    val incorrectWords: List<String>
)