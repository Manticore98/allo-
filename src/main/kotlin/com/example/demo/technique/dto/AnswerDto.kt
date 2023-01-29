package com.example.demo.technique.dto

import java.util.*

class AnswerDto {
    var id:Long? = null
    lateinit var body: String
    lateinit var channel:String

    constructor(qid: Long?, body: String, channel: String) {
        this.id = id
        this.body = body
        this.channel = channel
    }
}