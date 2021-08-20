package com.fatah.domain.usecases

import com.fatah.domain.entity.ResultsEntity

interface GetNowPlayingMovieTask {
    suspend operator fun invoke(api_key: String): Result<ResultsEntity>
}