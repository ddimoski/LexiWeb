package com.finki.lexiweb.domain

import com.finki.lexiweb.domain.enums.RoleEnum
import javax.persistence.*

@Entity
//@Table(name = "roles")
class Role(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private val id: Long,

    @Enumerated(EnumType.STRING)
    private val name: RoleEnum
)