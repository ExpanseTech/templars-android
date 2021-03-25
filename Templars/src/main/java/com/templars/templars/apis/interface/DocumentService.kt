package com.templars.templars.apis.`interface`

import com.google.gson.GsonBuilder
import com.templars.templars.models.Document
import com.templars.templars.models.DocumentCategory
import com.templars.templars.models.ResponseBody
import com.templars.templars.models.Session
import com.templars.templars.models.requestBody.CreateDocument
import com.templars.templars.models.requestBody.RescheduleSession
import com.templars.templars.models.requestBody.UpdateDocument
import com.templars.templars.utils.Constants
import com.templars.templars.utils.URLs
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*


interface DocumentService {

    @GET(URLs.getDocument)
    fun getDocument(@Header(Constants.AUTHORIZATION) token: String, @Path(Constants.ID) id: String): Call<ResponseBody<Document>>

    @GET(URLs.getDocuments)
    fun getDocuments(
        @Header(Constants.AUTHORIZATION) token: String, @Query(Constants.DRAFT) draft: Boolean,
        @Query(Constants.PAGE) page: Int, @Query(Constants.PAGE_SIZE) pageSize: Int,
        @Query(Constants.SORT_BY) sortBy: String
    ): Call<ResponseBody<List<Document>>>

    @GET(URLs.getPublicDocumentCategory)
    fun getDocumentCategory(@Header(Constants.AUTHORIZATION) token: String, @Path(Constants.ID) id: String): Call<ResponseBody<DocumentCategory>>

    @GET(URLs.getPublicDocumentCategories)
    fun getDocumentCategories(@Header(Constants.AUTHORIZATION) token: String): Call<ResponseBody<List<DocumentCategory>>>

    @POST(URLs.createDocument)
    fun createDocument(@Header(Constants.AUTHORIZATION) token: String, @Body body: CreateDocument): Call<ResponseBody<Document>>

    @PUT(URLs.updateDocument)
    fun updateDocument(@Header(Constants.AUTHORIZATION) apiKey: String, @Path(Constants.ID) id: String,
                          @Body body: UpdateDocument): Call<ResponseBody<Document>>

    companion object{
        val instance: DocumentService by lazy {
            val gson = GsonBuilder()
                .setLenient()
                .create()

            val retrofit = Retrofit.Builder()
                .baseUrl(URLs.baseURL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build()
            retrofit.create<DocumentService>(DocumentService::class.java)
        }
    }
}