package com.templars.templars_android_sdk

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.templars.templars.Templars
import com.templars.templars.models.Field
import com.templars.templars.models.requestBody.CreateDocument
import com.templars.templars.models.requestBody.CreateRegistration
import com.templars.templars.models.requestBody.CreateSession
import java.util.*

class MainActivity : AppCompatActivity() {

    private val templars = Templars("PUT YOUR API KEY HERE")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        createDocument()
//        createRegistration()
//        createSession()
//        rescheduleSession()
//        updateDocument()

//        allGetRequest()
    }

    private fun rescheduleSession() {
        templars.rescheduleSession("SESSION ID", Date(), 1) {
            it.onSuccess { resp ->
                Log.d(TAG, "Update Session: ${resp.data}")
            }

            it.onFailure { err ->
                Log.d(TAG, "Update Session Error: ${err.localizedMessage}")
            }
        }
    }

    private fun createSession() {
        val session = CreateSession(
            "SESSION TITLE",
            "DESCRIPTION",
            Date(),
            2,
            CreateSession.SessionType.VIDEO,
            "EMAIL ADDRESS",
            "LAWYER CATEGORY ID"
        )

        templars.createSession(session) {
            it.onSuccess { resp ->
                Log.d(TAG, "Session: ${resp.data}")
            }
            it.onFailure { err ->
                Log.d(TAG, "Session Error: ${err.localizedMessage}")
            }
        }
    }

    private fun createRegistration() {
        val body = CreateRegistration(
            "FIELDS",
            true,
            "EMAIL ADDRESS",
            "REGISTRATION CATEGORY ID"
        )

        templars.createRegistration(body) {
            it.onSuccess { resp ->
                Log.d(TAG, "Registration: ${resp.data}")
            }
            it.onFailure { err ->
                Log.d(TAG, "Registration Error: ${err.localizedMessage}")
            }
        }
    }

    private fun createDocument() {
        val document = CreateDocument(
            "DOCUMENT NAME",
            true,
            listOf(),
            "EMAIL ADDRESS",
            "DOCUMENT CATEGORY ID"
        )

        templars.createDocument(document) {
            it.onSuccess { resp ->
                Log.d(TAG, "Document: ${resp.data}")
            }

            it.onFailure { err ->
                Log.d(TAG, "Document Error: ${err.localizedMessage}")
            }
        }
    }

    fun getDocumentCategory() {
        templars.getDocumentCategory("DOCUMENT CATEGORY ID") {
            it.onSuccess { resp ->
                Log.d(TAG, "Documents Category: ${resp.data}")
            }

            it.onFailure { err ->
                Log.d(TAG, "Documents Category: ${err.localizedMessage}")
            }
        }
    }

    fun updateDocument() {
        val field1 = Field(
            "71d203d9-8c65-4a90-9471-e0436a11a695",
            "02/28/2019",
            Field.DataType.date,
            "MM/dd/yyyy"
        )
        val field2 = Field("dfc76195-74c9-4e13-8355-c2dd932e4799", "Martini", Field.DataType.text)
        val field3 = Field("a71e00ba-861d-4b49-97d6-5c93bdeb62fe", "Now", Field.DataType.text)
        val field4 = Field("65567f91-66aa-4277-a228-bc30f7654bb7", "No label", Field.DataType.text)
        val field5 =
            Field("341bd314-aead-441d-847f-8ea7d17c22bb", "I don't know", Field.DataType.text)
        val field6 = Field("dbc09501-daf8-48d4-88d6-e6823e397fb8", "LOL", Field.DataType.text)
        val field7 = Field("9912b124-9704-4f8f-ae2a-b9644c7e1369", "Hello", Field.DataType.text)

        val fields = ArrayList<Field>()
        fields.add(field1)
        fields.add(field2)
        fields.add(field3)
        fields.add(field4)
        fields.add(field5)
        fields.add(field6)
        fields.add(field7)

        templars.updateDocument("DOCUMENT ID", fields) {
            it.onSuccess { resp ->
                Log.d(TAG, "Update Document: ${resp.data}")
            }

            it.onFailure { err ->
                Log.d(TAG, "Update Document: ${err.localizedMessage}")
            }
        }
    }

    fun allGetRequest() {
        getDocuments()
        getDocument()
        getDocumentCategories()
        getDocumentCategory()

        getSessions()
        getSession()
        getRegistrations()
        getRegistration()

        getRegistrationCatgeories()
        getLawyerCategories()
    }

    private fun getLawyerCategories() {
        templars.getLawyerCategories {
            it.onSuccess { resp ->
                Log.d(TAG, "Lawyer Categories: ${resp.data}")
            }

            it.onFailure { err ->
                Log.d(TAG, "Lawyer Categories Error: ${err.localizedMessage}")
            }
        }
    }

    private fun getRegistrationCatgeories() {
        templars.getRegistrationCategories {
            it.onSuccess { resp ->
                Log.d(TAG, "Registration Categories: ${resp.data}")
            }

            it.onFailure { err ->
                Log.d(TAG, "Registration Categories Error: ${err.localizedMessage}")
            }
        }
    }

    private fun getRegistration() {
        templars.getRegistration("REGISTRATION ID") {
            it.onSuccess { resp ->
                Log.d(TAG, "Registration: ${resp.data}")
            }

            it.onFailure { err ->
                Log.d(TAG, "Registration Error: ${err.localizedMessage}")
            }
        }
    }

    private fun getRegistrations() {
        templars.getRegistrations {
            it.onSuccess { resp ->
                Log.d(TAG, "Registrations: ${resp.data}")
            }

            it.onFailure { err ->
                Log.d(TAG, "Registrations Error: ${err.localizedMessage}")
            }
        }
    }

    private fun getSession() {
        templars.getSession("SESSION ID") {
            it.onSuccess { resp ->
                Log.d(TAG, "Session: ${resp.data}")
            }

            it.onFailure { err ->
                Log.d(TAG, "Session Error: ${err.localizedMessage}")
            }
        }
    }

    private fun getSessions() {
        templars.getSessions {
            it.onSuccess { resp ->
                Log.d(TAG, "Sessions: ${resp.data}")
            }

            it.onFailure { err ->
                Log.d(TAG, "Sessions Error: ${err.localizedMessage}")
            }
        }
    }

    private fun getDocumentCategories() {
        templars.getDocumentCategories {
            it.onSuccess { resp ->
                Log.d(TAG, "Document Categories: ${resp?.data?.size}")
            }

            it.onFailure { err ->
                Log.d(TAG, "Document Categories Error: ${err.localizedMessage}")
            }
        }
    }

    private fun getDocument() {
        templars.getDocument("DOCUMENT ID") {
            it.onSuccess { resp ->
                Log.d(TAG, "Document: ${resp.data}")
            }

            it.onFailure { err ->
                Log.d(TAG, "Document Error: ${err.localizedMessage}")
            }
        }
    }

    private fun getDocuments() {
        templars.getDocuments {
            it.onSuccess { resp ->
                Log.d(TAG, "Documents: ${resp.data}")
            }

            it.onFailure { err ->
                Log.d(TAG, "Documents Error: ${err.localizedMessage}")
            }
        }
    }

    companion object {

        const val TAG = "MainActivity"
    }
}