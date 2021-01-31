package com.templars.templars.models.requestBody

public class CreateDocument (
    val name: String,
    val draft: Boolean,
    val fields: String,
    val customerReference: String,
    val categoryId: String
)