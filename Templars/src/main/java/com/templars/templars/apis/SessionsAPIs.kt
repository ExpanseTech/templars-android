package com.templars.templars.apis

import com.templars.templars.apis.`interface`.SessionService
import com.templars.templars.models.ApiError
import com.templars.templars.models.ResponseBody
import com.templars.templars.models.Session
import com.templars.templars.utils.handleData
import com.templars.templars.utils.handleError
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SessionsAPIs(private val apiKey: String) {

    val service = SessionService.instance

    fun getSession(id: String, callback: (Pair<ResponseBody<Session>?, ApiError?>) -> Unit){
        val sessionCall = service.getSession(apiKey, id)
        sessionCall.enqueue(object: Callback<ResponseBody<Session>>{
            override fun onResponse(
                call: Call<ResponseBody<Session>>,
                response: Response<ResponseBody<Session>>
            ) {
                response.handleData(callback)
            }

            override fun onFailure(call: Call<ResponseBody<Session>>, t: Throwable) {
                t.handleError(callback)
            }

        })
    }

    fun getSessions(callback: (Pair<ResponseBody<List<Session>>?, ApiError?>) -> Unit){
        val sessionsCall = service.getSessions(apiKey)
        sessionsCall.enqueue(object: Callback<ResponseBody<List<Session>>>{
            override fun onResponse(
                call: Call<ResponseBody<List<Session>>>,
                response: Response<ResponseBody<List<Session>>>
            ) {
                response.handleData(callback)
            }

            override fun onFailure(call: Call<ResponseBody<List<Session>>>, t: Throwable) {
                t.handleError(callback)
            }

        })
    }

}