package com.example.moviesapp.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.moviesapp.assets.Resource
import com.example.moviesapp.domainLayer.usecases.upcomingUc.UpcomingMovieUseCase
import com.example.moviesapp.presentation.viewstate.PopularMovieViewState
import com.example.moviesapp.presentation.viewstate.UpcomingMovieViewState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class UpcomingMovieViewModel @Inject constructor(private val useCase: UpcomingMovieUseCase):ViewModel() {

    private val mutableStateFlow = MutableStateFlow<UpcomingMovieViewState>(UpcomingMovieViewState())
    val stateFlow : StateFlow<UpcomingMovieViewState> = mutableStateFlow

    fun getUpcomingMovieList()
    {
        useCase.invoke().onEach {
            when(it)
            {
                is Resource.Loading->{
                    mutableStateFlow.value= UpcomingMovieViewState(true)
                }is Resource.Success->{
                mutableStateFlow.value= UpcomingMovieViewState(data = it.data)
                }is Resource.Error ->{
                    mutableStateFlow.value= UpcomingMovieViewState(error =it.message.orEmpty())
                }
            }
        }.launchIn(viewModelScope)

    }
}