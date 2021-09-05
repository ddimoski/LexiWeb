package com.finki.lexiweb.domain

import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import java.time.ZonedDateTime
import javax.persistence.*

@Entity
//@Table(name = "users")
class User(
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
) : UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private val id: Long  = 0
    override fun getAuthorities(): MutableCollection<out GrantedAuthority> {
        TODO("Not yet implemented")
    }

    override fun getPassword(): String {
        TODO("Not yet implemented")
    }

    override fun getUsername(): String {
        TODO("Not yet implemented")
    }

    override fun isAccountNonExpired(): Boolean {
        TODO("Not yet implemented")
    }

    override fun isAccountNonLocked(): Boolean {
        TODO("Not yet implemented")
    }

    override fun isCredentialsNonExpired(): Boolean {
        TODO("Not yet implemented")
    }

    override fun isEnabled(): Boolean {
        TODO("Not yet implemented")
    }
}