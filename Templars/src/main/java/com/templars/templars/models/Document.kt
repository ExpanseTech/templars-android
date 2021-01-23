package com.templars.templars.models

import java.util.*

data class Document(
    val name: String,
    val active: Boolean,
    val draft: Boolean,
    val categoryId: String,
    val userId: String,
    val createdAt: Date,
    val updatedAt: Date,
    val user: User
)