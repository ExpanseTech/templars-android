package com.templars.templars.apis.`interface`

import com.templars.templars.models.ResponseBody
import com.templars.templars.models.Session
import com.templars.templars.utils.URLs
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path

interface SessionService {

    @GET(URLs.getSession)
    fun getSession(@Header("authorization") apiKey: String, @Path("id") id: String): Call<ResponseBody<Session>>

    @GET(URLs.getSessions)
    fun getSessions(@Header("authorization") apiKey: String): Call<ResponseBody<List<Session>>>

    companion object{
        val instance: SessionService by lazy {
            val retrofit = Retrofit.Builder()
                .baseUrl(URLs.baseURL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            retrofit.create(SessionService::class.java)
        }
    }
}