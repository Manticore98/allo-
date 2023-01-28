package com.example.demo.technique.entities


import jakarta.persistence.*


@Entity
class HistoriqueQuestion(){

    @Id
    @GeneratedValue(strategy = GenerationType. IDENTITY)
    var id:Long? = null
    lateinit var histotitle:String
    lateinit var histostatus:String
}


