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

interface RegistrationService{

    @GET(URLs.getRegistration)
    fun getRegistration(@Header("authorization") apiKey: String, @Path("id") id: String): Call<ResponseBody<Registration>>

    @GET(URLs.getRegistrations)
    fun getRegistrations(@Header("authorization") apiKey: String, @Query(Constants.DRAFT) draft: Boolean,
                         @Query(Constants.PAGE) page: Int, @Query(Constants.PAGE_SIZE) pageSize: Int,
                         @Query(Constants.SORT_BY) sortBy: String): Call<ResponseBody<List<Registration>>>

    @GET(URLs.getRegistrationCategories)
    fun getRegistrationCategories(@Header("authorization") apiKey: String): Call<ResponseBody<List<RegistrationCategory>>>

    @POST(URLs.createRegistration)
    fun createRegistration(@Header(Constants.AUTHORIZATION) apiKey: String, @Body body: CreateRegistration): Call<ResponseBody<Registration>>

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