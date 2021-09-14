package com.fatah.data.model

data class ResultData(
    val adult: Boolean,
    val backdropPath: String,
    val genreIds: ArrayList<Number>,
    val id: Number,
    val originalLanguage: String,
    val originalTitle: String,
    val overview: String,
    val popularity: Double,
    val posterPath: String,
    val video: Boolean,
    val voteAverage: Double,
    val voteCount: Number
)

//fun ResultDataResponse.toEntity
