package com.finki.lexiweb.domain

import javax.persistence.*

@Entity
@Table(name = "words")
class Word (

    val name: String
    ) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0
}