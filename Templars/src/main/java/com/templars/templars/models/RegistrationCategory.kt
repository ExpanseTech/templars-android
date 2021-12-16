package com.templars.templars.models

import com.google.gson.annotations.SerializedName
import java.util.*

data class RegistrationCategory(
    val id: String,
    val createdAt: Date,
    val updatedAt: Date,
    val active: Boolean,
    val name: String,
    val slug: String,
    val description: String?,
    @SerializedName("public")
    val isPublic: Boolean,
    val price: Double
)