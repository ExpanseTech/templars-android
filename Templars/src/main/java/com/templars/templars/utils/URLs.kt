package com.templars.templars.utils


/**
 * All URLs for Templars API Request
 *
 */
class URLs {

    companion object{
        const val baseURL = "https://templars-api.herokuapp.com"

        //MARK: Documents API
        const val getDocuments = "/api/v1/documents/me/"
        const val getDocument = "/api/v1/documents/{id}"
        const val createDocument = "/api/v1/documents"
        const val updateDocument = "/api/v1/documents/{${Constants.ID}}"
        const val getPublicDocumentCategories = "/api/v1/document-categories/public/"
        const val getPublicDocumentCategory = "/api/v1/document-categories/{${Constants.ID}}"

        //MARK: Bussiness Registeration API
        const val getRegistration = "/api/v1/registrations/{id}"
        const val getRegistrations = "/api/v1/registrations/me"
        const val getRegistrationCategories = "/api/v1/document-categories/registration"
        const val createRegistration = "/api/v1/registrations"

        //MARK: Sessions API
        const val getSession = "/api/v1/sessions/{id}"
        const val getSessions = "/api/v1/sessions/me"
        const val createSession = "/api/v1/sessions"
        const val rescheduleSession = "/api/v1/sessions/{${Constants.ID}}/reschedule"

    }
}