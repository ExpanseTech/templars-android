package com.templars.templars.models

import java.util.*

data class User (
    val id: String,
    val createdAt: Date,
    val updatedAt: Date,
    val active: Boolean,
    val firstName: String,
    val lastName : String,
    val email : String,
    val phoneNumber : String,
    val verified : Boolean,
    val role : String
    )
