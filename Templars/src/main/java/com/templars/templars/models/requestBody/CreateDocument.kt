package com.templars.templars.models.requestBody

import com.templars.templars.models.Field

/**
 * Create Document Model
 *
 * @property name
 * @property draft
 * @property fields
 * @property customerReference
 * @property categoryId
 */
data class CreateDocument(
    val name: String,
    val draft: Boolean,
    val fields: List<Field>,
    val customerReference: String,
    val categoryId: String
)