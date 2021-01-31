package com.templars.templars.utils

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.templars.templars.models.ApiError
import com.templars.templars.models.Document
import com.templars.templars.models.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.HttpException
import retrofit2.Response

val Throwable.apiError: ApiError
    get() = ApiError("Error", localizedMessage)


public fun <T> Call<T>.enqueue(callback: (Result<T>) -> Unit) {
    enqueue(object: Callback<T> {
        override fun onResponse(call: Call<T>, response: Response<T>) {
            try {
                val result = Result.success(response.body()!!)
                callback(result)
            }catch(ex: Exception) {
                val result = Result.failure<T>(Throwable(response.message(), null))
                callback(result)
            }
        }

        override fun onFailure(call: Call<T>, t: Throwable) {
            val result = Result.failure<T>(t)

            callback(result)
        }

    })
}

fun <T> Throwable.handleError(callback: (Pair<T?, ApiError?>) -> Unit) {
    callback(Pair(null, apiError))
}

fun <T> Response<T>.handleData(callback: (Pair<T?, ApiError?>) -> Unit) {
    if (!this.isSuccessful){
        val type = object : TypeToken<ApiError>(){}.type
        val apiError: ApiError = Gson().fromJson(errorBody()!!.charStream(), type)
        callback(Pair(null, apiError))
    }
    callback(Pair(body(), null))
}