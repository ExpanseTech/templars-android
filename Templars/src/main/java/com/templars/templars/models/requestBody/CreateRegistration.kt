package com.templars.templars.models.requestBody

/**
 * Create Registration Model
 *
 * @property fields
 * @property draft
 * @property customerReference
 * @property categoryId
 */
class CreateRegistration (
    val fields: String,
    val draft: Boolean = true,
    val customerReference: String,
    val categoryId: String
    )