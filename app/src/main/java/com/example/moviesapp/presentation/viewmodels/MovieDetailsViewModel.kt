package com.example.moviesapp.presentation.viewmodels

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.moviesapp.assets.Resource
import com.example.moviesapp.dataLayer.models.movieDetails.MovieDetailsModel
import com.example.moviesapp.domainLayer.usecases.movieDetailsUc.MovieDetailsUseCase
import com.example.moviesapp.presentation.viewstate.MovieDetailsViewState
import com.example.moviesapp.presentation.viewstate.PopularMovieViewState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class MovieDetailsViewModel @Inject constructor( val movieDetailsUseCase: MovieDetailsUseCase) :ViewModel(){
    private val TAG = "MovieDetailsViewModel"
    private val mutableStateFlowCart = MutableStateFlow<MovieDetailsViewState>(MovieDetailsViewState())
    val stateFlowCart: StateFlow<MovieDetailsViewState> =mutableStateFlowCart

    fun getMovieDetails(movieId:String){
        movieDetailsUseCase.invoke(movieId).onEach {
            Log.i(TAG, "getPopularMovie: "+it.message)
            when(it)
            {
                is Resource.Loading->{
                    mutableStateFlowCart.value= MovieDetailsViewState(true)
                }is Resource.Success->{
                mutableStateFlowCart.value= MovieDetailsViewState(data = it.data)
            }is Resource.Error ->{
                mutableStateFlowCart.value= MovieDetailsViewState(error =it.message.orEmpty())
            }
            }
        }.launchIn(viewModelScope)
    }
}