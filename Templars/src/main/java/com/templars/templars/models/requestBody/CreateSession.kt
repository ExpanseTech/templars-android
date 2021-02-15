package com.templars.templars.models.requestBody

import java.util.*

/**
 * Create Session Model
 *
 * @property title
 * @property description
 * @property startDate
 * @property count
 * @property type
 * @property customerReference
 */
class CreateSession (
    val title: String,
    val description: String,
    val startDate: Date,
    var count: Int,
    var type: SessionType,
    val customerReference: String
        ){
    
    enum class SessionType{
        AUDIO, VIDEO, CHAT
    }
}