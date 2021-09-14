package com.fatah.data.repository

import com.fatah.data.mapper.Mapper
import com.fatah.data.model.LocalDataSource
import com.fatah.data.model.ResultData
import com.fatah.data.remote.api.RemoteDataSource
import com.fatah.data.remote.models.ResultNetwork
import com.fatah.domain.entity.ResultsEntity
import com.fatah.domain.repository.TheatreRepository
import com.fatah.domain.usecases.Result
import java.lang.Exception
import javax.inject.Inject

class TheatreRepositoryImpl @Inject constructor(
    private val movieMapper: Mapper<ResultsEntity, ResultData>,
    private val movieNetworkMapper: Mapper<ResultData, ResultNetwork>,
    private val localDataSource: LocalDataSource,
    private val remoteDataSource: RemoteDataSource
): TheatreRepository {

    override suspend fun getMovieResults(api_key: String, getFromRemote: Boolean): Result<ArrayList<ResultsEntity>> {
            return when {
                getFromRemote -> {
                    val remoteResultNetwork = remoteDataSource.getMoviesResult(api_key, "en", "popularity.desc")
                    if (remoteResultNetwork.isSuccessful) {
                        val remoteData = remoteResultNetwork.body()
                        if (remoteData != null) {
                            val movieResultsList = mutableListOf<ResultsEntity>();
                            for (movie in remoteData.results) {
                                movieResultsList.add(movieMapper.from(movieNetworkMapper.from(movie)))
                            }

                            Result.Success(ArrayList(movieResultsList))
                        } else {
                            Result.Success(null)
                        }
                    } else {
                        return Result.Error(Exception("Invalid Data, requested failed"))
                    }
                }
                else -> {
                    TODO()
                }
            }
    }
}