package com.templars.templars.apis

import com.templars.templars.apis.`interface`.LawyerService
import com.templars.templars.models.LawyerCategory
import com.templars.templars.models.ResponseBody
import com.templars.templars.utils.enqueue

class LawyerAPIs(private val apiKey: String) {

    private val service = LawyerService.instance

    fun getLawyerCategories(callback: (Result<ResponseBody<List<LawyerCategory>>>) -> Unit) {
        val lawyerCall = service.getLawyersCategories(apiKey)
        lawyerCall.enqueue(callback)
    }
}