package com.templars.templars.models

data class SubscriptionPlan (
    val name: String,
    val amount: String,
    val description: String,
    val reference: String,
    val registrations: String,
    val documents: String,
    val sessions: String,
    val interval: String,
    val createdAt: String,
    val updatedAt: String,
    val active: String
)