package com.example.demo.technique.dto

import org.hibernate.annotations.CreationTimestamp
import java.util.*

class QuestionDto {

    var qid:Long? = null
    lateinit var title:String
    var promoted:Boolean = false
    var status:String="Draft"
    lateinit var created_at: Date
    lateinit var updated_at: Date

    constructor(qid: Long?, title: String, promoted: Boolean, status: String) {
        this.qid = qid
        this.title = title
        this.promoted = promoted
        this.status = status
    }
}