package com.templars.templars.apis

import com.templars.templars.apis.`interface`.DocumentService
import com.templars.templars.models.ApiError
import com.templars.templars.models.Document
import com.templars.templars.models.ResponseBody
import com.templars.templars.utils.handleData
import com.templars.templars.utils.handleError
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DocumentAPIs(private val apiKey: String) {

    private val documentService = DocumentService.instance

    fun getDocument(id: String, callback: (Pair<ResponseBody<Document>?, ApiError?>) -> Unit){
        val doc = documentService.getDocument(apiKey, id)
        doc.enqueue(object : Callback<ResponseBody<Document>>{
            override fun onResponse(
                call: Call<ResponseBody<Document>>,
                response: Response<ResponseBody<Document>>
            ) {
                response.handleData(callback)

            }

            override fun onFailure(call: Call<ResponseBody<Document>>, t: Throwable) {
                t.handleError(callback)
            }

        })
    }

    fun getDocuments(callback: (Pair<ResponseBody<List<Document>>?, ApiError?>) -> Unit){
        val callDoc = documentService.getDocuments(apiKey)
        callDoc.enqueue(object : Callback<ResponseBody<List<Document>>> {

            override fun onResponse(
                call: Call<ResponseBody<List<Document>>>,
                response: Response<ResponseBody<List<Document>>>
            ) {
                //callback(Pair(response.body(), null))
                response.handleData(callback)
            }

            override fun onFailure(
                call: Call<ResponseBody<List<Document>>>,
                t: Throwable
            ) {
                //callback(Pair(null, t.apiError))
                t.handleError(callback)
            }
        })
    }
}

