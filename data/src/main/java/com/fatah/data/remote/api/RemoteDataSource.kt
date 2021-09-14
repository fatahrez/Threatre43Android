package com.fatah.data.remote.api

import com.fatah.data.model.ResultData
import com.fatah.data.remote.models.ResultNetworkWrapper
import com.fatah.domain.usecases.Result
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface RemoteDataSource {
    @GET("3/discover/movie")
    suspend fun getMoviesResult(@Query("api_key") api_key: String,
                        @Query("language") language: String,
                        @Query("sort_by") sort_by: String
    ): Response<ResultNetworkWrapper>
}