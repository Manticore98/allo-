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
    /*fun getId(): Long? {
        return id
    }
    fun getBody():String{
        return body
    }
    fun getChannel() : String{
        return channel
    }
    fun setId(id : Long?){
        this.id=id
    }
    fun setBody(body :String){
        this.body=body
    }
    fun setChannel(channel:String){
        this.channel=channel
    }*/
}