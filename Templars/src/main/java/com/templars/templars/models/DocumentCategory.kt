package com.templars.templars.models

import com.google.gson.annotations.SerializedName
import java.util.*

/**
 * Document Category
 *
 * @property id
 * @property isActive
 * @property createdAt
 * @property updatedAt
 * @property name
 * @property slug
 * @property description
 * @property isPublic
 * @property price
 * @property parent
 */
data class DocumentCategory (
    val id: String,
    @SerializedName("active")
    val isActive: Boolean,
    val createdAt: Date,
    val updatedAt: Date,
    val name: String,
    val slug: String,
    val description: String,
    @SerializedName("public")
    val isPublic: Boolean,
    val price: Double,
    val parent: DocumentCategory
)
