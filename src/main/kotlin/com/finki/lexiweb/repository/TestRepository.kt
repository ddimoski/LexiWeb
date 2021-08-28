package com.finki.lexiweb.repository

import com.finki.lexiweb.domain.Test
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface TestRepository : JpaRepository<Test, Long> {
}