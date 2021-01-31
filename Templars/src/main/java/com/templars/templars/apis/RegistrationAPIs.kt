package com.templars.templars.apis

import com.templars.templars.apis.`interface`.RegistrationService
import com.templars.templars.models.*
import com.templars.templars.models.requestBody.CreateRegistration
import com.templars.templars.utils.enqueue

class RegistrationAPIs(private val apiKey: String) {

    private val service = RegistrationService.instance

    fun getRegistration(id: String, callback: (Result<ResponseBody<Registration>>) -> Unit){
        val registrationCall = service.getRegistration(apiKey, id)
        registrationCall.enqueue(callback)
    }

    fun getRegistrations(draft: Boolean, page: Int, pageSize: Int, sortBy: SortBy, callback: (Result<ResponseBody<List<Registration>>>) -> Unit){
        val registrationsCall = service.getRegistrations(apiKey, draft, page, pageSize, sortBy.toString())
        registrationsCall.enqueue(callback)
    }

    fun getRegistrationCategories(callback: (Result<ResponseBody<List<RegistrationCategory>>>) -> Unit){
        val registrationCall = service.getRegistrationCategories(apiKey)
        registrationCall.enqueue(callback)
    }

    fun createRegistration(registration: CreateRegistration, callback: (Result<ResponseBody<Registration>>) -> Unit){
        val registrationCall = service.createRegistration(apiKey, registration)
        registrationCall.enqueue(callback)
    }
}