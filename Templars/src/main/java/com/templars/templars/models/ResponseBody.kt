package com.templars.templars.models

/**
 * Expected response structure from Templars APIs
 * Uses Generic type for [data] to accommodate all data types
 *
 * @param T
 * @property message
 * @property data
 * @property meta
 */
data class ResponseBody<T>(
    val message: String,
    val data: T?,
    val meta: Meta?
)

/**
 * Meta is holds information about list returned in [ResponseBody]
 *
 * @property perPage
 * @property total
 * @property count
 * @property currentPage
 * @property totalPages
 */
data class Meta(
    val perPage: Int,
    val total: Int,
    val count: Int,
    val currentPage: Int,
    val totalPages: Int
)