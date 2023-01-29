package com.example.demo.technique.repository

import com.example.demo.technique.entities.HistoriqueQuestion
import org.springframework.data.jpa.repository.JpaRepository

interface HistoriqueQuestionRepo : JpaRepository<HistoriqueQuestion,Long> {
}