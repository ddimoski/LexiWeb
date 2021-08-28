package com.finki.lexiweb.domain

import javax.persistence.*

@Entity
class Question(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private val id: Long,

    @OneToOne
    private val mainWord: Word,

    @OneToOne
    private val matchingWord: Word,

    @OneToMany
    private val incorrectWords: List<Word>
)