package com.templars.templars

import com.templars.templars.apis.DocumentAPIs
import com.templars.templars.apis.RegistrationAPIs
import com.templars.templars.apis.SessionsAPIs
import com.templars.templars.models.*

public class Templars(val apiKey: String) {
    private val documentApis = DocumentAPIs(apiKey)
    private val sessionApis = SessionsAPIs(apiKey)
    private val registrationAPIs = RegistrationAPIs(apiKey)

    public fun getDocument(id: String, callback: (Pair<ResponseBody<Document>?, ApiError?>) -> Unit){
        documentApis.getDocument(id, callback)
    }

    public fun getDocuments(callback: (Pair<ResponseBody<List<Document>>?, ApiError?>) -> Unit){
        documentApis.getDocuments(callback)
    }

    fun getSession(id: String, callback: (Pair<ResponseBody<Session>?, ApiError?>) -> Unit){
        sessionApis.getSession(id, callback)
    }

    fun getSessions(callback: (Pair<ResponseBody<List<Session>>?, ApiError?>) -> Unit){
        sessionApis.getSessions(callback)
    }

    fun getRegistration(id: String, callback: (Pair<ResponseBody<Registration>?, ApiError?>) -> Unit){
        registrationAPIs.getRegistration(id, callback)
    }

    fun getRegistrations(callback: (Pair<ResponseBody<List<Registration>>?, ApiError?>) -> Unit){
        registrationAPIs.getRegistrations(callback)
    }
}