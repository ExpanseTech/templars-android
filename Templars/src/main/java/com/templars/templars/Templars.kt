package com.templars.templars

import com.templars.templars.apis.DocumentAPIs
import com.templars.templars.apis.RegistrationAPIs
import com.templars.templars.apis.SessionsAPIs
import com.templars.templars.models.*
import com.templars.templars.models.requestBody.CreateDocument
import com.templars.templars.models.requestBody.CreateRegistration
import com.templars.templars.models.requestBody.CreateSession
import java.util.*

public class Templars(val apiKey: String) {
    private val documentApis = DocumentAPIs(apiKey)
    private val sessionApis = SessionsAPIs(apiKey)
    private val registrationAPIs = RegistrationAPIs(apiKey)

    fun getDocument(id: String, callback: (Result<ResponseBody<Document>>) -> Unit){
        documentApis.getDocument(id, callback)
    }

    fun getDocuments(draft: Boolean = false, page: Int = 1, pageSize: Int = 30, sortBy: SortBy = SortBy.creationDate,
                     callback: (Result<ResponseBody<List<Document>>>) -> Unit){

        documentApis.getDocuments(draft, page, pageSize, sortBy, callback)
    }

    fun getDocumentCategories(callback: (Result<ResponseBody<List<DocumentCategory>>?>) -> Unit){
        documentApis.getDocumentCategories(callback)
    }

    fun createDocument(document: CreateDocument, callback: (Result<ResponseBody<Document>>) -> Unit){
        documentApis.createDocument(document, callback)
    }

    fun updateDocument(documentId: String, fields: String,callback: (Result<ResponseBody<Document>>) -> Unit){
        documentApis.updateDocument(documentId, fields, callback)
    }


    fun getSession(id: String, callback: (Result<ResponseBody<Session>>) -> Unit){
        sessionApis.getSession(id, callback)
    }

    fun getSessions(draft: Boolean = false, page: Int = 1, pageSize: Int = 30, sortBy: SortBy = SortBy.creationDate,
                    callback: (Result<ResponseBody<List<Session>>>) -> Unit){
        sessionApis.getSessions(draft, page, pageSize, sortBy, callback)
    }

    fun createSession(session: CreateSession, callback: (Result<ResponseBody<Session>>) -> Unit){
        sessionApis.createSession(session, callback)
    }

    fun rescheduleSession(sessionId: String, newDate: Date? = null, count: Int, callback: (Result<ResponseBody<Session>>) -> Unit){
        sessionApis.rescheduleSession(sessionId, newDate, count, callback)
    }



    fun getRegistration(id: String, callback: (Result<ResponseBody<Registration>>) -> Unit){
        registrationAPIs.getRegistration(id, callback)
    }

    fun getRegistrations(draft: Boolean = false, page: Int = 1, pageSize: Int = 30, sortBy: SortBy = SortBy.creationDate,
                         callback: (Result<ResponseBody<List<Registration>>>) -> Unit){

        registrationAPIs.getRegistrations(draft, page, pageSize, sortBy, callback)
    }

    fun getRegistrationCategories(callback: (Result<ResponseBody<List<RegistrationCategory>>>) -> Unit){
        registrationAPIs.getRegistrationCategories(callback)
    }

    fun createRegistration(createRegistration: CreateRegistration, callback: (Result<ResponseBody<Registration>>) -> Unit){
        registrationAPIs.createRegistration(createRegistration, callback)
    }
}