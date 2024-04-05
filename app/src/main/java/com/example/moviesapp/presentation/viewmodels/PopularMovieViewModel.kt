package com.example.moviesapp.presentation.viewmodels

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.moviesapp.assets.Resource
import com.example.moviesapp.domainLayer.usecases.popularUc.PopularMovieUseCase
import com.example.moviesapp.presentation.viewstate.PopularMovieViewState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class PopularMovieViewModel @Inject constructor(private val popularMovieRepositoryUseCase: PopularMovieUseCase):ViewModel() {
    private val TAG = "PopularMovieViewModel"
    private val mutableStateFlowCart = MutableStateFlow<PopularMovieViewState>(PopularMovieViewState())
    val stateFlowCart: StateFlow<PopularMovieViewState> =mutableStateFlowCart

    fun getPopularMovie(){
        popularMovieRepositoryUseCase.invoke().onEach {
            Log.i(TAG, "getPopularMovie: "+it.message)
            when(it)
            {
                is Resource.Loading->{
                    mutableStateFlowCart.value= PopularMovieViewState(true)
                }is Resource.Success->{
                    mutableStateFlowCart.value= PopularMovieViewState(data = it.data)
                }is Resource.Error ->{
                    mutableStateFlowCart.value= PopularMovieViewState(error =it.message.orEmpty())
                 }
            }
        }.launchIn(viewModelScope)
    }
}