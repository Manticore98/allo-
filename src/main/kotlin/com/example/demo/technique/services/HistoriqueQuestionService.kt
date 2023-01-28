package com.example.demo.technique.services

import com.example.demo.technique.Repository.HistoriqueQuestionRepo
import com.example.demo.technique.dto.HistoriqueQuestionDto
import com.example.demo.technique.entities.HistoriqueQuestion
import org.springframework.jdbc.core.JdbcTemplate


class HistoriqueQuestionService(val jdbcTemplate: JdbcTemplate, val histoQuestionRepo: HistoriqueQuestionRepo) {
    fun save(histoQuestionDto: HistoriqueQuestionDto){
        val historQuestion : HistoriqueQuestion = HistoriqueQuestion()
        historQuestion.histotitle=histoQuestionDto.histotitle
        historQuestion.histostatus=histoQuestionDto.histostatus
        this.histoQuestionRepo.save(historQuestion);
    }
    fun creatHisto(){
        jdbcTemplate.execute("create table if not exists histoquestions(qid Serial Primary Key,"+"title Varchar(100),"+"status varchar);")
    }

}