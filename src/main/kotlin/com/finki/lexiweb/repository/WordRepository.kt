package com.finki.lexiweb.repository

import com.finki.lexiweb.domain.Word
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface WordRepository : JpaRepository<Word, Long> {
}