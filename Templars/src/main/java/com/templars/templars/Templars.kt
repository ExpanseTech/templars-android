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

    /**
     * Gets user's document with [id]
     *
     * @param id
     * @param callback
     */
    fun getDocument(id: String, callback: (Result<ResponseBody<Document>>) -> Unit){
        documentApis.getDocument(id, callback)
    }

    /**
     * Gets user's document
     *
     * @param draft
     * @param page
     * @param pageSize
     * @param sortBy
     * @param callback
     */
    fun getDocuments(draft: Boolean = false, page: Int = 1, pageSize: Int = 30, sortBy: SortBy = SortBy.CreationDate,
                     callback: (Result<ResponseBody<List<Document>>>) -> Unit){

        documentApis.getDocuments(draft, page, pageSize, sortBy, callback)
    }

    /**
     * Gets all Documents Category type
     *
     * @param callback
     */
    fun getDocumentCategories(callback: (Result<ResponseBody<List<DocumentCategory>>?>) -> Unit){
        documentApis.getDocumentCategories(callback)
    }

    /**
     * Create a Document
     *
     * @param document
     * @param callback
     */
    fun createDocument(document: CreateDocument, callback: (Result<ResponseBody<Document>>) -> Unit){
        documentApis.createDocument(document, callback)
    }

    /**
     * Update a Document
     *
     * @param documentId
     * @param fields
     * @param callback
     */
    fun updateDocument(documentId: String, fields: String,callback: (Result<ResponseBody<Document>>) -> Unit){
        documentApis.updateDocument(documentId, fields, callback)
    }


    /**
     * Get a session using its [id]
     *
     * @param id
     * @param callback
     */
    fun getSession(id: String, callback: (Result<ResponseBody<Session>>) -> Unit){
        sessionApis.getSession(id, callback)
    }

    /**
     * Get User's Sessions
     *
     * @param draft
     * @param page
     * @param pageSize
     * @param sortBy
     * @param callback
     */
    fun getSessions(draft: Boolean = false, page: Int = 1, pageSize: Int = 30, sortBy: SortBy = SortBy.CreationDate,
                    callback: (Result<ResponseBody<List<Session>>>) -> Unit){
        sessionApis.getSessions(draft, page, pageSize, sortBy, callback)
    }

    /**
     * Create Session for a User
     *
     * @param session
     * @param callback
     */
    fun createSession(session: CreateSession, callback: (Result<ResponseBody<Session>>) -> Unit){
        sessionApis.createSession(session, callback)
    }

    /**
     * Reschedule Session
     *
     * @param sessionId
     * @param newDate
     * @param count
     * @param callback
     */
    fun rescheduleSession(sessionId: String, newDate: Date? = null, count: Int, callback: (Result<ResponseBody<Session>>) -> Unit){
        sessionApis.rescheduleSession(sessionId, newDate, count, callback)
    }

    /**
     * Get a Registered Entity by its' [id]
     *
     * @param id
     * @param callback
     */
    fun getRegistration(id: String, callback: (Result<ResponseBody<Registration>>) -> Unit){
        registrationAPIs.getRegistration(id, callback)
    }

    /**
     * Get a User's registered entities
     *
     * @param draft
     * @param page
     * @param pageSize
     * @param sortBy
     * @param callback
     */
    fun getRegistrations(draft: Boolean = false, page: Int = 1, pageSize: Int = 30, sortBy: SortBy = SortBy.CreationDate,
                         callback: (Result<ResponseBody<List<Registration>>>) -> Unit){

        registrationAPIs.getRegistrations(draft, page, pageSize, sortBy, callback)
    }

    /**
     * Get all categories For Registered entities
     *
     * @param callback
     */
    fun getRegistrationCategories(callback: (Result<ResponseBody<List<RegistrationCategory>>>) -> Unit){
        registrationAPIs.getRegistrationCategories(callback)
    }

    /**
     * Register an Entity
     *
     * @param createRegistration
     * @param callback
     */
    fun createRegistration(createRegistration: CreateRegistration, callback: (Result<ResponseBody<Registration>>) -> Unit){
        registrationAPIs.createRegistration(createRegistration, callback)
    }
}