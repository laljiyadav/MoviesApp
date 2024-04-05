package com.example.moviesapp.presentation.viewstate

import com.example.moviesapp.dataLayer.models.popular.PopularMovieListModel

data class PopularMovieViewState(val isLoading:Boolean=false,
                                 val data: PopularMovieListModel?=null,
                                 val error:String="")
