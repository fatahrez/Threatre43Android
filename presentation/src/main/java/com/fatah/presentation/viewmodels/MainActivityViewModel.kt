package com.fatah.presentation.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fatah.domain.entity.ResultsEntity
import com.fatah.domain.usecases.GetNowPlayingMovieImpl
import com.fatah.domain.usecases.Result
import com.fatah.presentation.mapper.Mapper
import com.fatah.presentation.models.ResultsModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor(
    private val resultsEntityPresentationMapper: Mapper<ResultsEntity, ResultsModel>,
    private val getNowPlayingMovieImpl: GetNowPlayingMovieImpl,
    private val api_key: String
): ViewModel() {
    private val movieMutableLiveData = MutableLiveData<Result<ArrayList<ResultsModel>>>()

    val movies: LiveData<Result<ArrayList<ResultsModel>>>
        get() = movieMutableLiveData

    init {
        fetchMovies(api_key)
    }

    private fun fetchMovies(api_key: String) {
        viewModelScope.launch {
            movieMutableLiveData.postValue(Result.Loading)
            getNowPlayingMovieImpl.invoke(api_key, true).let {
                for (resultEntity in ) {
                    resultsEntityPresentationMapper.from(resultEntity)
                }
                movieMutableLiveData.postValue(

                )
            }

        }
    }
}