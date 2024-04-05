package com.example.moviesapp.presentation.viewstate

import com.example.moviesapp.dataLayer.models.popular.PopularMovieListModel
import com.example.moviesapp.dataLayer.models.upcoming.UpcomingMoviesListModel

data class UpcomingMovieViewState(val isLoading:Boolean=false,
                                  val data: UpcomingMoviesListModel?=null,
                                  val error:String="")
