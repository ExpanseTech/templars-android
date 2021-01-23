package com.templars.templars.apis.`interface`

import com.google.gson.GsonBuilder
import com.templars.templars.models.Registration
import com.templars.templars.models.ResponseBody
import com.templars.templars.utils.URLs
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path

interface RegistrationService{

    @GET(URLs.getRegistration)
    fun getRegistration(@Header("authorization") apiKey: String, @Path("id") id: String): Call<ResponseBody<Registration>>

    @GET(URLs.getRegistrations)
    fun getRegistrations(@Header("authorization") apiKey: String): Call<ResponseBody<List<Registration>>>

    companion object{
        private val gson = GsonBuilder().setLenient().create()
        val instance: RegistrationService by lazy {
            val retrofit = Retrofit.Builder()
                .baseUrl(URLs.baseURL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build()
            retrofit.create<RegistrationService>(RegistrationService::class.java)
        }
    }
}