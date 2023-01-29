package com.example.demo.technique.services

import com.example.demo.technique.dto.HistoriqueQuestionDto
import com.example.demo.technique.entities.HistoriqueQuestion
import com.example.demo.technique.repository.HistoriqueQuestionRepo
import org.apache.commons.csv.CSVFormat
import org.apache.commons.csv.CSVPrinter
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.stereotype.Service
import java.io.IOException
import java.io.Writer

@Service

class HistoriqueQuestionService @Autowired constructor(
    val jdbcTemplate: JdbcTemplate,
    val histoQuestionRepo: HistoriqueQuestionRepo
) {

    val logger = LoggerFactory.getLogger("HistoriqueQuestionService")

    fun save(histoQuestionDto: HistoriqueQuestionDto) {
        val historQuestion: HistoriqueQuestion = HistoriqueQuestion()
        historQuestion.histotitle = histoQuestionDto.histotitle
        historQuestion.histostatus = histoQuestionDto.histostatus
        this.histoQuestionRepo.save(historQuestion)
    }

    fun createTable() {
        jdbcTemplate.execute("create table if not exists histoquestions(qid Serial Primary Key," + "title Varchar(100)," + "status varchar);")
    }


    fun writeHistoricQuestionsToCsv(writer: Writer) {
        logger.info("Récupération des questions à exporter")
        val historiqueQuestions: List<HistoriqueQuestion> = histoQuestionRepo.findAll()
        try {
            logger.info("Traitement des données et création du fichier CSV")
            val csvPrinter = CSVPrinter(writer, CSVFormat.DEFAULT)
            for (historiqueQuestion in historiqueQuestions) {
                csvPrinter.printRecord(
                    historiqueQuestion.id,
                    historiqueQuestion.histostatus,
                    historiqueQuestion.histotitle
                )
            }
        } catch (e: IOException) {
            logger.error("Erreur leur de l'écriture du fichier CSV", e)
        }
    }
}

