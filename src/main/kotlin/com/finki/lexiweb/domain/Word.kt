package com.finki.lexiweb.domain

import javax.persistence.*

@Entity
@Table(name = "words")
class Word (private val name: String) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private val id: Long = 0
}