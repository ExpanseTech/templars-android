package com.templars.templars.models

import java.util.*

/**
 * Registration
 *
 * @property id
 * @property template
 * @property fields
 * @property draft
 * @property status
 * @property createdAt
 * @property updatedAt
 * @property active
 * @property user
 * @property categoryId
 * @property userId
 */
data class Registration (
    val id: String,
    val template: String,
    val fields: String,
    val draft: Boolean,
    val status: String,
    val createdAt: Date,
    val updatedAt: Date,
    val active: Boolean,
    val user: User,
    val categoryId: String,
    val userId: String
    )