package com.fatah.presentation.models

data class ResultsModel(
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
