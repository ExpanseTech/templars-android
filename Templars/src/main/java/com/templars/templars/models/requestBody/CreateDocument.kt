package com.templars.templars.models.requestBody

/**
 * Create Document Model
 *
 * @property name
 * @property draft
 * @property fields
 * @property customerReference
 * @property categoryId
 */
public class CreateDocument (
    val name: String,
    val draft: Boolean,
    val fields: String,
    val customerReference: String,
    val categoryId: String
)