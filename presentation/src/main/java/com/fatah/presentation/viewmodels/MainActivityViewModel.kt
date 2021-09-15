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
import com.fatah.presentation.util.NetworkHelper
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.lang.Exception
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor(
    private val resultsEntityPresentationMapper: Mapper<ResultsEntity, ResultsModel>,
    private val getNowPlayingMovieImpl: GetNowPlayingMovieImpl,
    private val networkHelper: NetworkHelper,
    api_key: String
): ViewModel() {
    private val movieMutableLiveData = MutableLiveData<Result<ArrayList<ResultsEntity>>>()

    val movies: LiveData<Result<ArrayList<ResultsEntity>>>
        get() = movieMutableLiveData

    init {
        fetchMovies(api_key)
    }

    private fun fetchMovies(api_key: String) {
        viewModelScope.launch {
            movieMutableLiveData.postValue(Result.Loading)
            getNowPlayingMovieImpl.invoke(api_key, true).let {

//                Result.Success(it)
                if (networkHelper.isNetworkConnected()) {
                    movieMutableLiveData.postValue(it)
                } else {
                    movieMutableLiveData.postValue(Result.Error(Exception("Network Error")))
                }
            }

        }
    }
}