package com.example.demo.technique.dto

class HistoriqueQuestionDto {
    var id:Long? = null
    lateinit var histotitle: String
    lateinit var histostatus:String

    constructor(id: Long?, histotitle: String, histostatus: String) {
        this.id = id
        this.histotitle = histotitle
        this.histostatus = histostatus
    }
}