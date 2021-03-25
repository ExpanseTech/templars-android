package com.templars.templars_android_sdk

import android.nfc.Tag
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Switch
import com.templars.templars.Templars
import com.templars.templars.models.Document
import com.templars.templars.models.Field
import com.templars.templars.models.requestBody.CreateDocument
import com.templars.templars.models.requestBody.CreateRegistration
import com.templars.templars.models.requestBody.CreateSession
import com.templars.templars.models.requestBody.Tuple
import java.util.*

class MainActivity : AppCompatActivity() {
    lateinit var templars: Templars

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Templars.apiKey = ""

        templars = Templars.instance

//        val document = CreateDocument("My Document 500x", true, "Some fields",
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


//        val body = CreateRegistration("More 34", true,
//            "matthew.chukwuemeka40@gmail.com",
//            "3398477d-33a3-4e4c-ba5f-6963d0de09ee")
//        templars.createRegistration(body){
//            it.onSuccess { resp ->
//                Log.d(TAG, "Registration: ${resp.data?.fields}")
//            }
//            it.onFailure { err ->
//                Log.d(TAG, "Registration Error: ${err.localizedMessage}")
//            }
//
//        }


//        val session = CreateSession("MYY Session23", "No description",
//            Date(1616664565000), 2, CreateSession.SessionType.VIDEO,
//            "matthew.chukwuemeka40@gmail.com")
//        templars.createSession(session){
//            it.onSuccess { resp ->
//                Log.d(TAG, "Session: ${resp.data?.title}")
//            }
//            it.onFailure { err ->
//                Log.d(TAG, "Session Error: ${err.localizedMessage}")
//            }
//        }

//        templars.rescheduleSession("6d0721d8-bd40-4186-8e7e-a88d55cbe83d", Date(1616664565000), 1){
//            it.onSuccess { resp ->
//                Log.d(TAG, "Update Session: ${resp.data?.title}")
//            }
//
//            it.onFailure { err ->
//                Log.d(TAG, "Update Session Error: ${err.localizedMessage}")
//            }
//        }

        //allGetRequest()
        //getDocumentCategory()
        updateDocument()
    }

    fun getDocumentCategory(){
        templars.getDocumentCategory("506c5806-cc9b-4f8b-a83d-81083a3cbc01"){
            it.onSuccess { resp ->
                val fields = resp.data?.fields
                templars.updateDocument("506c5806-cc9b-4f8b-a83d-81083a3cbc01", fields!!){
                    it.onSuccess {
                        Log.d(TAG, "Documents Category: Success Update")
                    }
                    it.onFailure { err ->
                        Log.d(TAG, "Documents Category: ${err.localizedMessage}")
                    }
                }
                Log.d(TAG, "Documents Category: ${resp.data?.name}")
            }

            it.onFailure { err ->
                Log.d(TAG, "Documents Category: ${err.localizedMessage}")
            }
        }
    }

    fun updateDocument(){
        val field1 = Field("71d203d9-8c65-4a90-9471-e0436a11a695", "02/28/2019", Field.DataType.date, "MM/dd/yyyy")
        val field2 = Field("dfc76195-74c9-4e13-8355-c2dd932e4799", "Martini", Field.DataType.text)
        val field3 = Field("a71e00ba-861d-4b49-97d6-5c93bdeb62fe", "Now", Field.DataType.text)
        val field4 = Field("65567f91-66aa-4277-a228-bc30f7654bb7", "No label", Field.DataType.text)
        val field5 = Field("341bd314-aead-441d-847f-8ea7d17c22bb", "I don't know", Field.DataType.text)
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

        templars.updateDocument("f87d01f9-7a5e-4d8f-8221-4be37042476a", fields){
            it.onSuccess { resp ->
                Log.d(TAG, "updateDocument: Success")
                print(resp.data?.userId)
            }

            it.onFailure {
                Log.d(TAG, "updateDocument: Failed")
            }
        }
//        val createDocument = CreateDocument("Android doc", false, fields, "matthew.chukwuemeka40@gmail.com", "f87d01f9-7a5e-4d8f-8221-4be37042476a")
//        templars.createDocument(createDocument){
//            it.onSuccess {
//                Log.d(TAG, "updateDocument: success")
//            }
//            it.onFailure { error ->
//                Log.d(TAG, "updateDocument failed: ${error.localizedMessage}")
//            }
//        }

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

        templars.getRegistration("09ebf8e2-8d47-4661-9dcc-b06382dfc88e"){
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