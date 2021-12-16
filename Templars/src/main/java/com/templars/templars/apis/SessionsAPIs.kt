package com.templars.templars.apis

import com.templars.templars.apis.`interface`.SessionService
import com.templars.templars.models.ResponseBody
import com.templars.templars.models.Session
import com.templars.templars.models.SortBy
import com.templars.templars.models.requestBody.CreateSession
import com.templars.templars.models.requestBody.RescheduleSession
import com.templars.templars.utils.Constants
import com.templars.templars.utils.enqueue
import java.util.*

class SessionsAPIs(private val apiKey: String) {

    private val service = SessionService.instance

    fun getSession(id: String, callback: (Result<ResponseBody<Session>>) -> Unit) {
        val sessionCall = service.getSession(apiKey, id)
        sessionCall.enqueue(callback)
    }

    fun getSessions(
        draft: Boolean?,
        page: Int,
        pageSize: Int,
        sortBy: SortBy,
        callback: (Result<ResponseBody<List<Session>>>) -> Unit
    ) {
        val queryMap = hashMapOf(
            Constants.PAGE to page,
            Constants.PAGE_SIZE to pageSize,
            Constants.SORT_BY to sortBy.toString()
        )

        if (draft != null) {
            queryMap[Constants.DRAFT] to draft
        }

        val sessionsCall = service.getSessions(apiKey, queryMap)
        sessionsCall.enqueue(callback)
    }

    fun rescheduleSession(
        id: String,
        newDate: Date?,
        count: Int?,
        callback: (Result<ResponseBody<Session>>) -> Unit
    ) {
        val body = RescheduleSession(newDate, count)
        val sessionCall = service.rescheduleSession(apiKey, id, body)
        sessionCall.enqueue(callback)
    }

    fun createSession(session: CreateSession, callback: (Result<ResponseBody<Session>>) -> Unit) {
        val sessionDoc = service.createSession(apiKey, session)
        sessionDoc.enqueue(callback)
    }
}