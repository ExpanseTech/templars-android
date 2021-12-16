package com.templars.templars.utils

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * Extension func for generic [Call] type,
 * it handles success and error response from the server
 *
 * @param T
 * @param callback
 */
fun <T> Call<T>.enqueue(callback: (Result<T>) -> Unit) {
    enqueue(object : Callback<T> {
        override fun onResponse(call: Call<T>, response: Response<T>) {
            try {
                if (response.isSuccessful.not()) {
                    val result = Result.failure<T>(Throwable(response.errorBody()?.string()))
                    callback(result)
                    return
                }

                val result = Result.success(response.body()!!)
                callback(result)
            } catch (ex: Exception) {
                val result = Result.failure<T>(Throwable(response.message()))
                callback(result)
            }
        }

        override fun onFailure(call: Call<T>, t: Throwable) {
            val result = Result.failure<T>(t)
            callback(result)
        }
    })
}