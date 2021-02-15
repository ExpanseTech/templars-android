package com.templars.templars.utils

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.templars.templars.models.TError
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

val Throwable.tError: TError
    get() = TError("Error", localizedMessage)


/**
 * Extension func for generic [Call] type,
 * it handles success and error response from the server
 *
 * @param T
 * @param callback
 */
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
