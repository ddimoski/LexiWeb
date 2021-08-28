package com.finki.lexiweb.domain

import javax.persistence.*

@Entity
class Test(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private val id: Long,

    private val name: String,

    @OneToMany
    private val questions: List<Question>
)