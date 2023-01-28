package com.example.demo.technique.services
import com.example.demo.technique.dto.QuestionDto
import com.example.demo.technique.repository.QuestionRepo
import com.example.demo.technique.entities.Question
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.PostMapping
import java.io.IOException
import java.sql.Timestamp
import java.util.*

@Service
class QuestionsServices @Autowired constructor(val jdbcTemplate: JdbcTemplate, val questionRepo: QuestionRepo){

    fun creat(){
        jdbcTemplate.execute("create table if not exists question (" +"qid Serial  PRIMARY KEY ,"+ "title VARCHAR(100) ," +
                "promoted boolean ," +
                "status varchar,"+
                " created_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP ," +
                " updated_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP );")
    }

    fun findQuestions(): List<Question> = questionRepo.findAll().toList()
    fun save(questionDto: QuestionDto){

        val question : Question = Question() ;
        if(questionDto.title.isEmpty()){
            throw IllegalStateException("Title required")
        }else{
            if (questionDto.title.length>100){
                throw IOException("100 character max")
            }
            question.title = questionDto.title;
        }
        if(questionDto.status=="Draft" || questionDto.status=="Published"){
            question.status=questionDto.status
        }else{
            throw IllegalStateException("Doesn t match with requirement")
        }
        question.promoted=questionDto.promoted
        this.questionRepo.save(question);
    }

    fun updatequestion(titre:String,status:String,newtitle:String,newstat:String){
        jdbcTemplate.update("update questions set title=?,status=? where title=?",newtitle,newstat,titre)
    }
    fun findTitleById(id: Long): Optional<Question> = questionRepo.findById(id)
   /* fun updateQuestionTitle(questionDto: QuestionDto,id:Long){
        val question : Question = Question()
        val list : List<Question> = findTitleById(id)
        if(questionRepo.findById(id).isPresent){
            question.title=questionDto.title
            question.status=questionDto.status
        }else{

        }
    }*/
}