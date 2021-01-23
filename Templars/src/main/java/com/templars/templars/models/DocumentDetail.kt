package com.templars.templars.models

import java.util.*

data class DocumentDetail (
    val template: String,
    val name: String,
    val fields: String,
    val draft: Boolean,
    val createdAt: Date,
    val updatedAt: Date,
    val active: Boolean,
    val category: DocumentCategory,
    val categoryId: String,
    val user: User,
    val userId: String,
)