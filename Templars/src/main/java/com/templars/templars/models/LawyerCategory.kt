package com.templars.templars.models

data class LawyerCategory(
    val id: String,
    val active: Boolean,
    val name: String,
    val sessionPrice: Double,
    val description: String,
)