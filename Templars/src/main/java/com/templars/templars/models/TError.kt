package com.templars.templars.models

/**
 * Error From Templar Server
 *
 * @property property
 * @property message
 */
data class TError (
    val property: String?,
    val message: String?
){

}