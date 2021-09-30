package com.finki.lexiweb.domain

import javax.persistence.*

@Entity
@Table(name = "tests")
class Test(
    val name: String,

    @OneToMany
    val questions: List<Question>
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    internal val id: Long  = 0
}