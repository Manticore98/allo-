package com.example.demo.technique.entities


import java.util.Date
import jakarta.persistence.*
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp


@Entity
class Question (){

    @Id
    @GeneratedValue(strategy = GenerationType. IDENTITY)
    var qid:Long? = null
    lateinit var title:String
    var promoted:Boolean = false
    var status:String="Draft"
    @field:CreationTimestamp
    lateinit var created_at : Date
    @field:UpdateTimestamp
    lateinit var updated_at: Date

}


