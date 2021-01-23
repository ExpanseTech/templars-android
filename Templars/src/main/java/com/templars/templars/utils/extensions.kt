package com.templars.templars.utils

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.templars.templars.models.ApiError
import com.templars.templars.models.Document
import com.templars.templars.models.ResponseBody
import retrofit2.Response

val Throwable.apiError: ApiError
    get() = ApiError("", localizedMessage)

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