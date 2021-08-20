package com.fatah.domain.entity

data class ResultsEntity(
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