package com.templars.templars.apis

import com.templars.templars.apis.`interface`.RegistrationService
import com.templars.templars.models.Registration
import com.templars.templars.models.RegistrationCategory
import com.templars.templars.models.ResponseBody
import com.templars.templars.models.SortBy
import com.templars.templars.models.requestBody.CreateRegistration
import com.templars.templars.utils.Constants
import com.templars.templars.utils.enqueue

class RegistrationAPIs(private val apiKey: String) {

    private val service = RegistrationService.instance

    fun getRegistration(id: String, callback: (Result<ResponseBody<Registration>>) -> Unit) {
        val registrationCall = service.getRegistration(apiKey, id)
        registrationCall.enqueue(callback)
    }

    fun getRegistrations(
        draft: Boolean?,
        page: Int,
        pageSize: Int,
        sortBy: SortBy,
        callback: (Result<ResponseBody<List<Registration>>>) -> Unit
    ) {
        val queryMap = hashMapOf(
            Constants.PAGE to page,
            Constants.PAGE_SIZE to pageSize,
            Constants.SORT_BY to sortBy.toString()
        )

        if (draft != null) {
            queryMap[Constants.DRAFT] to draft
        }

        val registrationsCall = service.getRegistrations(apiKey, queryMap)
        registrationsCall.enqueue(callback)
    }

    fun getRegistrationCategories(callback: (Result<ResponseBody<List<RegistrationCategory>>>) -> Unit) {
        val registrationCall = service.getRegistrationCategories(apiKey)
        registrationCall.enqueue(callback)
    }

    fun createRegistration(
        registration: CreateRegistration,
        callback: (Result<ResponseBody<Registration>>) -> Unit
    ) {
        val registrationCall = service.createRegistration(apiKey, registration)
        registrationCall.enqueue(callback)
    }
}