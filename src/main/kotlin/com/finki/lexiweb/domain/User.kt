package com.finki.lexiweb.domain

import java.time.ZonedDateTime
import javax.persistence.*

@Entity
//@Table(name = "users")
class User(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private val id: Long,

    private val username: String,

    private val password: String,

    private val firstName: String,

    private val lastName: String,

    private val email: String,

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "user_roles",
        joinColumns = [JoinColumn(name = "user_id")],
        inverseJoinColumns = [JoinColumn(name = "role_id")]
    )
    private val roles: Set<Role> = HashSet(),

    private val dateOfBirth: ZonedDateTime
) {
}