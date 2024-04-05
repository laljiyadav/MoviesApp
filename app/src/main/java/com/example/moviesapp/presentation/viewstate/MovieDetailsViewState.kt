package com.example.moviesapp.presentation.viewstate

import com.example.moviesapp.dataLayer.models.movieDetails.MovieDetailsModel
import com.example.moviesapp.dataLayer.models.popular.PopularMovieListModel

data class MovieDetailsViewState(val isLoading:Boolean=false,
                                 val data: MovieDetailsModel?=null,
                                 val error:String="")
