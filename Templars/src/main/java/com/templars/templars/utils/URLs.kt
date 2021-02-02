package com.templars.templars.utils

class URLs {

    companion object{
        const val baseURL = "http://templars-api.herokuapp.com"
        private const val basicListSuffix = "?page={${Constants.PAGE}}&draft={${Constants.DRAFT}}&pageSize={${Constants.PAGE_SIZE}}&sortBy={${Constants.SORT_BY}}"

        //MARK: Documents API
        const val getDocuments = "/api/v1/documents/me/"
        const val getDocument = "/api/v1/documents/{id}"
        const val createDocument = "/api/v1/documents"
        const val updateDocument = "/api/v1/documents/{${Constants.ID}}"
        const val deleteDocument = "/api​/v1​/documents/%s"
        const val updateDocumentPayment = "/api​/v1​/documents/%s/payment"
        const val getPublicDocumentCategories = "/api/v1/document-categories/public/"

        //MARK: Bussiness Registeration API
        const val getRegistration = "/api/v1/registrations/{id}"
        const val getRegistrations = "/api/v1/registrations/me"
        const val getRegistrationCategories = "/api/v1/document-categories/registration"
        const val createRegistration = "/api/v1/registrations"

        //MARK: Sessions API
        const val getSession = "/api/v1/sessions/{id}"
        const val getSessions = "/api/v1/sessions/me"
        const val createSession = "/api/v1/sessions"
        const val cancelSession = "/api/v1/sessions/%s/cancel"
        const val endSession = "/api/v1/sessions/%s/end"
        const val rescheduleSession = "/api/v1/sessions/{${Constants.ID}}/reschedule"

        //MARK: Subscribtion Management APIs
        const val getSubscriptions = "/api/v1/subscriptions"
        const val createSubscriptions = "/api/v1/subscriptions"
        const val getMySubscriptions = "/api​/v1​/subscriptions​/me"
        const val getActiveSubscription = "/api/v1/subscriptions/me/active"
        const val endSubscription = "/api​/v1​/subscriptions​/%s​/end"

        //MARK: Payment APIs

        //MARK: Profile APIs
        const val userProfile = "/api/v1/users/%s"
        const val toggleState = "/api/v1/users/%s/toggle-status"
    }
}