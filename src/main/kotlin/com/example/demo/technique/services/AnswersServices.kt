package com.example.demo.technique.services

import com.example.demo.technique.dto.AnswerDto
import com.example.demo.technique.dto.QuestionDto
import com.example.demo.technique.entities.Answer
import com.example.demo.technique.entities.Question
import com.example.demo.technique.repository.AnswerRepo
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.stereotype.Service
import java.io.IOException

@Service
class AnswersServices @Autowired constructor(val jdbcTemplate: JdbcTemplate,val answerRepo: AnswerRepo) {

    fun creat(){
        jdbcTemplate.execute("create table if not exists answers (" + "anid Serial  PRIMARY KEY ," +
                "body varchar(500)  ," +
                " channel varchar );")
    }
    /*fun findAnswers(): List<Answer> = jdbcTemplate.query("select (body,channel) from answers") { response, _ ->
        Answer(response.getString("body"), response.getString("channel"))
    }*/
    //fun findAnswers(): List<Answer> = answerRepo.findAll().toList()

    /*fun save(answer: Answer){
        jdbcTemplate.update("insert into answers (body,channel) values ( ? ,?)",
           answer.body, answer.channel)
    }*/
    fun save(answerDto: AnswerDto){

        val answer : Answer = Answer() ;
        if(answerDto.body.isEmpty()){
            throw IllegalStateException("Body required")
        }else{
            if (answerDto.body.length>500){
                throw IOException("100 character max")
            }
            answer.body = answerDto.body;
        }
        if(answerDto.channel=="Faq" || answerDto.channel=="Bot"){
            answer.channel=answerDto.channel
        }else {
            throw IllegalStateException("Doesn t match with requirement")
        }
        this.answerRepo.save(answer);
    }

}