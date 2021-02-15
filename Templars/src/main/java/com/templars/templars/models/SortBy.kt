package com.templars.templars.models

/**
 * Options for sorting entities such as Documents and Sessions
 *creationDate: sorts entity by creation date in ascending order
 * creationDateInverse: sorts entity by creation date in descending order
 */
enum class SortBy {
    CreationDate, CreationDateInverse;

    @Override
    override fun toString(): String {
        return when(this){
            CreationDate -> "createdAt"
            CreationDateInverse -> "-createdAt"
        }
    }
}