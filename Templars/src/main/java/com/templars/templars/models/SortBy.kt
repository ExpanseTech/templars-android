package com.templars.templars.models

enum class SortBy {
    creationDate, creationDateInvers;

    @Override
    override fun toString(): String {
        return when(this){
            creationDate -> "createdAt"
            creationDateInvers -> "-createdAt"
        }
    }
}