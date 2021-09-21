package com.finki.lexiweb.repository

import com.finki.lexiweb.domain.Role
import com.finki.lexiweb.domain.enums.RoleEnum
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface RoleRepository : JpaRepository<Role, Long> {
    fun findByName(name: RoleEnum): Role
}