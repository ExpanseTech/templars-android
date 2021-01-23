package com.templars.templars.models

public data class ResponseBody<T> (
    val message: String,
    val data: T,
    var meta: Meta
)

public data class Meta(
    val perPage: Int,
    val total: Int,
    val count: Int,
    val currentPage: Int,
    val totalPages: Int
)