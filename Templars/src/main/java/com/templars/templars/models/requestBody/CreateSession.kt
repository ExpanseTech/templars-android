package com.templars.templars.models.requestBody

import java.util.*

/**
 * Create Session Model
 *
 * @property title
 * @property description
 * @property startDate
 * @property count
 * @property type
 * @property customerReference
 * @property lawyerCategoryId
 */
data class CreateSession(
    val title: String,
    val description: String,
    val startDate: Date,
    val count: Int,
    val type: SessionType,
    val customerReference: String,
    val lawyerCategoryId: String,
) {

    enum class SessionType {
        AUDIO, VIDEO, CHAT
    }
}