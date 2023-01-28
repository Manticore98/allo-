package com.example.demo.technique.controllers

import com.example.demo.technique.dto.QuestionDto
import com.example.demo.technique.services.QuestionsServices
import com.example.demo.technique.entities.Question
import org.springframework.web.bind.annotation.*
import java.awt.PageAttributes.MediaType
import java.io.IOException

@RestController
class QuestionsController(val service: QuestionsServices) {

    @PostMapping("/questions", consumes = [org.springframework.http.MediaType.ALL_VALUE])
    fun post(@RequestBody questionDto: QuestionDto) {
        service.save(questionDto)
    }

    @PostMapping("/question/init")
    fun init(){
        service.creat()
    }

    @GetMapping("/questions/aff")
    fun index(): List<Question> = service.findQuestions()

}
