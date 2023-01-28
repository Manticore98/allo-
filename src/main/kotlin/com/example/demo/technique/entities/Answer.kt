package com.example.demo.technique.entities


import java.util.Date
import jakarta.persistence.*


@Entity
class Answer (){

    @Id
    @GeneratedValue(strategy = GenerationType. IDENTITY)
    var id:Long? = null
    lateinit var body: String
    lateinit var channel:String
}


