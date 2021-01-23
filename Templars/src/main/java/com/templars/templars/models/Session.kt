package com.templars.templars.models

import java.util.*

class Session (
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
    ){


    public enum class SessionType{
        audio, video, chat
    }
}