package com.templars.templars.models

import java.util.*

/**
 * Document
 *
 * @property name
 * @property active
 * @property draft
 * @property categoryId
 * @property userId
 * @property createdAt
 * @property updatedAt
 * @property user
 */
data class Document(
    val id: String,
    val name: String,
    val active: Boolean,
    val draft: Boolean,
    val categoryId: String,
    val userId: String,
    val createdAt: Date,
    val updatedAt: Date,
    val user: User
)