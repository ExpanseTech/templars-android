package com.templars.templars.apis.`interface`

import com.templars.templars.models.LawyerCategory
import com.templars.templars.models.ResponseBody
import com.templars.templars.utils.URLs
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Header

interface LawyerService {

    @GET(URLs.getLawyersCategories)
    fun getLawyersCategories(@Header("authorization") apiKey: String): Call<ResponseBody<List<LawyerCategory>>>

    companion object{
        val instance: LawyerService by lazy {
            val retrofit = Retrofit.Builder()
                .baseUrl(URLs.baseURL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            retrofit.create(LawyerService::class.java)
        }
    }
}