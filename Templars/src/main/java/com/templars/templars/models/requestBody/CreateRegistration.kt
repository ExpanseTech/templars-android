package com.templars.templars.models.requestBody

class CreateRegistration (
    val fields: String,
    val draft: Boolean = true,
    val customerReference: String,
    val categoryId: String
    )