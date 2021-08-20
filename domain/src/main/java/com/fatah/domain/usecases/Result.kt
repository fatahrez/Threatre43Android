package com.fatah.domain.usecases

import java.lang.Exception

sealed class Result<out T> {
    data class Success<out T>(val data: T): Result<T>()
    data class Error(val exception: Exception): Result<Nothing>()
    object Loading : Result<Nothing>()

    override fun toString(): String {
        return when(this) {
            is Success<*> -> "Success[data=$data]"
            is Error -> "Error[Exception=$exception]"
            is Loading -> "Loading..."
        }
    }
}