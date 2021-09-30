package com.finki.lexiweb.domain

import javax.persistence.*

@Entity
@Table(name = "questions")
class Question(
    @OneToOne
    val mainWord: Word,

    @OneToOne
    val matchingWord: Word,

    @OneToMany
    val incorrectWords: List<Word>
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0
}