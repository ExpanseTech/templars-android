package com.templars.templars.apis.`interface`

import com.google.gson.GsonBuilder
import com.templars.templars.models.Registration
import com.templars.templars.models.RegistrationCategory
import com.templars.templars.models.ResponseBody
import com.templars.templars.models.requestBody.CreateRegistration
import com.templars.templars.utils.Constants
import com.templars.templars.utils.URLs
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*

interface RegistrationService {

    @GET(URLs.getRegistration)
    fun getRegistration(
        @Header(Constants.AUTHORIZATION) apiKey: String,
        @Path("id") id: String
    ): Call<ResponseBody<Registration>>

    @GET(URLs.getRegistrations)
    fun getRegistrations(
        @Header(Constants.AUTHORIZATION) apiKey: String,
        @QueryMap queryMap: Map<String, @JvmSuppressWildcards Any?>
    ): Call<ResponseBody<List<Registration>>>

    @GET(URLs.getRegistrationCategories)
    fun getRegistrationCategories(@Header(Constants.AUTHORIZATION) apiKey: String): Call<ResponseBody<List<RegistrationCategory>>>

    @POST(URLs.createRegistration)
    fun createRegistration(
        @Header(Constants.AUTHORIZATION) apiKey: String,
        @Body body: CreateRegistration
    ): Call<ResponseBody<Registration>>

    companion object {
        private val gson = GsonBuilder().setLenient().create()
        val instance: RegistrationService by lazy {
            val retrofit = Retrofit.Builder()
                .baseUrl(URLs.baseURL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build()
            retrofit.create(RegistrationService::class.java)
        }
    }
}