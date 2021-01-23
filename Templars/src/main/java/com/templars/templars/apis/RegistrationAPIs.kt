package com.templars.templars.apis

import com.templars.templars.apis.`interface`.RegistrationService
import com.templars.templars.models.ApiError
import com.templars.templars.models.Registration
import com.templars.templars.models.ResponseBody
import com.templars.templars.utils.handleData
import com.templars.templars.utils.handleError
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RegistrationAPIs(private val apiKey: String) {

    val service = RegistrationService.instance

    fun getRegistration(id: String, callback: (Pair<ResponseBody<Registration>?, ApiError?>) -> Unit){
        val registrationCall = service.getRegistration(apiKey, id)
        registrationCall.enqueue(object: Callback<ResponseBody<Registration>>{
            override fun onResponse(
                call: Call<ResponseBody<Registration>>,
                response: Response<ResponseBody<Registration>>
            ) {
                response.handleData(callback)
            }

            override fun onFailure(call: Call<ResponseBody<Registration>>, t: Throwable) {
                t.handleError(callback)
            }

        })
    }

    fun getRegistrations(callback: (Pair<ResponseBody<List<Registration>>?, ApiError?>) -> Unit){
        val registrationsCall = service.getRegistrations(apiKey)
        registrationsCall.enqueue(object: Callback<ResponseBody<List<Registration>>>{
            override fun onResponse(
                call: Call<ResponseBody<List<Registration>>>,
                response: Response<ResponseBody<List<Registration>>>
            ) {
                response.handleData(callback)
            }

            override fun onFailure(call: Call<ResponseBody<List<Registration>>>, t: Throwable) {
                t.handleError(callback)
            }
        })
    }
}