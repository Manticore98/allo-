package com.example.demo.technique.controllers

import com.example.demo.technique.dto.AnswerDto
import com.example.demo.technique.dto.QuestionDto
import com.example.demo.technique.services.AnswersServices
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class AnswersController(val service: AnswersServices) {

    @PostMapping("/answers", consumes = [org.springframework.http.MediaType.ALL_VALUE])
    fun post(@RequestBody answerDto: AnswerDto) {
        service.save(answerDto)
    }

    @PostMapping("/answer/init")
    fun init(){
        service.creat()
    }
    /*@GetMapping("/answers/aff")
    fun index(): List<Answer> = service.findAnswers()*/
}