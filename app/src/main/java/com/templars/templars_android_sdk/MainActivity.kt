package com.templars.templars_android_sdk

import android.nfc.Tag
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Switch
import com.templars.templars.Templars
import com.templars.templars.models.requestBody.CreateDocument
import com.templars.templars.models.requestBody.CreateRegistration
import com.templars.templars.models.requestBody.CreateSession
import java.util.*

class MainActivity : AppCompatActivity() {
    lateinit var templars: Templars

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        templars = Templars("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiI2NjFhYTdmNC0xYjg4LTQ0OGYtYTlhNS0xN2VlZjVkMmJiN2QiLCJleHAiOjE2MTY3NjQ2NzcsImlhdCI6MTYxNDE3MjY3Nn0.St8ff2Pq0EpbCETf8kByvC--MKsL9BkAUuD5_d92ICE")

//        val document = CreateDocument("My Document 500", true, "Some fields",
//            "matthew.chukwuemeka40@gmail.com", "506c5806-cc9b-4f8b-a83d-81083a3cbc01")
//        templars.createDocument(document){
//            it.onSuccess { resp ->
//                Log.d(TAG, "Document: ${resp.data?.name}")
//            }
//
//            it.onFailure { err ->
//                Log.d(TAG, "Document Error: ${err.localizedMessage}")
//            }
//        }

//        templars.updateDocument("09ebf8e2-8d47-4661-9dcc-b06382dfc88e", "Updated Fields"){
//            it.onSuccess { resp ->
//                Log.d(TAG, "Document: ${resp.data?.name}")
//            }
//
//            it.onFailure { err ->
//                Log.d(TAG, "Document Error: ${err.localizedMessage}")
//            }
//        }


//        val body = CreateRegistration("More 2", true,
//            "matthew.chukwuemeka40@gmail.com",
//            "3398477d-33a3-4e4c-ba5f-6963d0de09ee")
//        templars.createRegistration(body){
//            it.onSuccess { resp ->
//                Log.d(TAG, "Registration: ${resp.data.fields}")
//            }
//            it.onFailure { err ->
//                Log.d(TAG, "Registration Error: ${err.localizedMessage}")
//            }
//
//        }


//        val session = CreateSession("MYY Session", "No description",
//            Date(1613652531000), 2, CreateSession.SessionType.VIDEO,
//            "matthew.chukwuemeka40@gmail.com")
//        templars.createSession(session){
//            it.onSuccess { resp ->
//                Log.d(TAG, "Registration: ${resp.data?.title}")
//            }
//            it.onFailure { err ->
//                Log.d(TAG, "Registration Error: ${err.localizedMessage}")
//            }
//        }

//        templars.rescheduleSession("6d0721d8-bd40-4186-8e7e-a88d55cbe83d", Date(1613652531000), 1){
//            it.onSuccess { resp ->
//                Log.d(TAG, "Session: ${resp.data?.title}")
//            }
//
//            it.onFailure { err ->
//                Log.d(TAG, "Session Error: ${err.localizedMessage}")
//            }
//        }

        allGetRequest()

    }

    fun allGetRequest(){
        templars.getDocuments {
            it.onSuccess { resp ->
                Log.d(TAG, "Documents: ${resp.data?.size}")
            }

            it.onFailure { err ->
                Log.d(TAG, "Documents Error: ${err.localizedMessage}")
            }
        }

        templars.getDocument("093a1a63-cf0e-461d-b238-c7dd749d0c63"){
            it.onSuccess { resp ->
                Log.d(TAG, "Document: ${resp.data?.name}")
            }

            it.onFailure { err ->
                Log.d(TAG, "Document Error: ${err.localizedMessage}")
            }
        }

        templars.getDocumentCategories {

            it.onSuccess { resp ->
                Log.d(TAG, "Document Categories: ${resp?.data?.size}")
            }

            it.onFailure { err ->
                Log.d(TAG, "Document Categories Error: ${err.localizedMessage}")
            }
        }

        templars.getSessions {
            it.onSuccess { resp ->
                Log.d(TAG, "Sessions Categories: ${resp?.data?.size}")
            }

            it.onFailure { err ->
                Log.d(TAG, "Sessions Categories Error: ${err.localizedMessage}")
            }
        }

        templars.getSession("0d257a09-96ec-4bd0-addc-c03108eaf000"){
            it.onSuccess { resp ->
                Log.d(TAG, "Session: ${resp.data?.title}")
            }

            it.onFailure { err ->
                Log.d(TAG, "Session Error: ${err.localizedMessage}")
            }
        }

        templars.getRegistrations {
            it.onSuccess { resp ->
                Log.d(TAG, "Registrations: ${resp.data?.size}")
            }

            it.onFailure { err ->
                Log.d(TAG, "Registrations Error: ${err.localizedMessage}")
            }
        }

        templars.getRegistration("bf33e29c-2f9a-47c4-b031-78a70e18bf3e"){
            it.onSuccess { resp ->
                Log.d(TAG, "Registration: ${resp.data?.fields}")
            }

            it.onFailure { err ->
                Log.d(TAG, "Registration Error: ${err.localizedMessage}")
            }
        }

        templars.getRegistrationCategories {
            it.onSuccess { resp ->
                Log.d(TAG, "Registration Categories: ${resp.data?.size}")
            }

            it.onFailure { err ->
                Log.d(TAG, "Registration Categories Error: ${err.localizedMessage}")
            }
        }
    }

    companion object{

        const val TAG = "MainActivity"

    }
}