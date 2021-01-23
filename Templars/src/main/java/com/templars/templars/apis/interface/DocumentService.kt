package com.templars.templars.apis.`interface`

import com.templars.templars.models.Document
import com.templars.templars.models.DocumentCategory
import com.templars.templars.models.ResponseBody
import com.templars.templars.utils.URLs
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path

interface DocumentService {

    @GET(URLs.getDocument)
    fun getDocument(@Header("authorization") token: String, @Path("id") id: String): Call<ResponseBody<Document>>

    @GET(URLs.getDocuments)
    fun getDocuments(@Header("authorization") token: String): Call<ResponseBody<List<Document>>>

    @GET("/api/v1/documents/me")
    fun getDocumentCategories(@Header("authorization") token: String): Call<ResponseBody<List<DocumentCategory>>>


    companion object{
        val instance: DocumentService by lazy {
            val retrofit = Retrofit.Builder()
                .baseUrl(URLs.baseURL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            retrofit.create<DocumentService>(DocumentService::class.java)
        }
    }
}