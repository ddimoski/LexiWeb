package com.finki.lexiweb.domain

import javax.persistence.*

@Entity
class Test(
    private val name: String,

    @OneToMany
    private val questions: List<Question>
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    internal val id: Long  = 0
}