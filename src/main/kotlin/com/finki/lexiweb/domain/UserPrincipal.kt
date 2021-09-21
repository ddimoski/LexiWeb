package com.finki.lexiweb.domain

import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import java.util.stream.Collectors


class UserPrincipal(val user: User) : UserDetails {
    override fun getAuthorities(): Collection<SimpleGrantedAuthority> =
        user.roles.stream()
            .map { SimpleGrantedAuthority(it.name.toString()) }
            .collect(Collectors.toList())

    override fun isEnabled(): Boolean = true

    override fun getUsername(): String = user.username

    override fun isCredentialsNonExpired(): Boolean = true

    override fun getPassword(): String = user.password

    override fun isAccountNonExpired(): Boolean = true

    override fun isAccountNonLocked(): Boolean = true
}