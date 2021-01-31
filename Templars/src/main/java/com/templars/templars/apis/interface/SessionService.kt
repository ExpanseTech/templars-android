package com.templars.templars.apis.`interface`

import com.templars.templars.models.ResponseBody
import com.templars.templars.models.Session
import com.templars.templars.models.requestBody.CreateSession
import com.templars.templars.models.requestBody.RescheduleSession
import com.templars.templars.utils.Constants
import com.templars.templars.utils.URLs
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*

interface SessionService {

    @GET(URLs.getSession)
    fun getSession(@Header("authorization") apiKey: String, @Path("id") id: String): Call<ResponseBody<Session>>

    @GET(URLs.getSessions)
    fun getSessions(@Header("authorization") apiKey: String, @Query(Constants.DRAFT) draft: Boolean,
                    @Query(Constants.PAGE) page: Int, @Query(Constants.PAGE_SIZE) pageSize: Int,
                    @Query(Constants.SORT_BY) sortBy: String): Call<ResponseBody<List<Session>>>

    @PUT(URLs.rescheduleSession)
    fun rescheduleSession(@Header(Constants.AUTHORIZATION) apiKey: String, @Path(Constants.ID) id: String,
                          @Body body: RescheduleSession): Call<ResponseBody<Session>>

    @POST(URLs.createSession)
    fun createSession(@Header(Constants.AUTHORIZATION) apiKey: String, @Body session: CreateSession): Call<ResponseBody<Session>>

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