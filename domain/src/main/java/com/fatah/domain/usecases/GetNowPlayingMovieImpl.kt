package com.fatah.domain.usecases

import com.fatah.domain.entity.ResultsEntity
import com.fatah.domain.repository.TheatreRepository
import javax.inject.Inject

class GetNowPlayingMovieImpl @Inject constructor(
    private val theatreRepository: TheatreRepository
): GetNowPlayingMovieTask {
    override suspend fun invoke(api_key: String) = theatreRepository.getMovieResults(api_key)
}