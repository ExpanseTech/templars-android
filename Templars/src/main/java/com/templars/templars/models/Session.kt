package com.templars.templars.models

import java.util.*

/**
 * Session
 *
 * @property id
 * @property title
 * @property description
 * @property meetingId
 * @property meetingUrl
 * @property startDate
 * @property endDate
 * @property count
 * @property duration
 * @property reschedules
 * @property type
 * @property status
 * @property createdAt
 * @property updatedAt
 * @property active
 * @property user
 * @property assignee
 */
data class Session(
    val id: String,
    val title: String,
    val description: String,
    val meetingId: String,
    val meetingUrl: String,
    val startDate: String,
    val endDate: String,
    val count: Int,
    val duration: Int,
    val reschedules: Int,
    val type: SessionType,
    val status: String,
    val createdAt: Date,
    val updatedAt: Date,
    val active: Boolean,
    val user: User,
    val assignee: User?
) {

    enum class SessionType {
        audio, video, chat
    }
}