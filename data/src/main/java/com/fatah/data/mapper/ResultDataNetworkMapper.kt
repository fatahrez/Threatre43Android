package com.fatah.data.mapper

import com.fatah.data.model.ResultData
import com.fatah.data.remote.models.ResultNetwork
import javax.inject.Inject

class ResultDataNetworkMapper @Inject constructor(): Mapper<ResultData, ResultNetwork> {
    override fun from(e: ResultNetwork): ResultData = ResultData(
        e.adult ?: false,
        e.backdropPath ?: "",
        e.genreIds ?: ArrayList(),
        e.id ?: 0,
        e.originalLanguage ?: "",
        e.originalTitle ?: "",
        e.overview ?: "",
        e.popularity ?: 0.0,
        e.posterPath ?: "",
        e.video ?: false,
        e.voteAverage ?: 0.0,
        e.voteCount ?: 0
    )

    override fun to(t: ResultData): ResultNetwork = ResultNetwork(
        t.adult ?: false,
        t.backdropPath ?: "",
        t.genreIds ?: ArrayList(),
        t.id ?: 0,
        t.originalLanguage ?: "",
        t.originalTitle ?: "",
        t.overview ?: "",
        t.popularity ?: 0.0,
        t.posterPath ?: "",
        t.video ?: false,
        t.voteAverage ?: 0.0,
        t.voteCount ?: 0
    )

}