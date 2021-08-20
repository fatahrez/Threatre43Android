package com.fatah.domain.repository

import com.fatah.domain.entity.ResultsEntity
import com.fatah.domain.usecases.Result

interface TheatreRepository {
    suspend fun getMovieResults(api_key: String): Result<ResultsEntity>
}