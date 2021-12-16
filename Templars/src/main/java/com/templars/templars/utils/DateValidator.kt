package com.templars.templars.utils

import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

class DateValidator(private val dateFormat: String) {

    fun isValid(dateString: String): Boolean {
        val sdf = SimpleDateFormat(dateFormat, Locale.getDefault())
        sdf.isLenient = false

        try {
            sdf.parse(dateString)
        } catch (e: ParseException) {
            return false
        }

        return true
    }
}