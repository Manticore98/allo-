package com.example.demo.technique.repository

import com.example.demo.technique.entities.Answer
import org.springframework.data.jpa.repository.JpaRepository


interface AnswerRepo : JpaRepository<Answer,Long>{}