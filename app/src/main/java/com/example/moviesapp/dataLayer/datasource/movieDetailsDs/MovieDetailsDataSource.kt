package com.example.moviesapp.dataLayer.datasource.movieDetailsDs

import com.example.moviesapp.dataLayer.models.movieDetails.MovieDetailsModel
import com.example.moviesapp.dataLayer.models.popular.PopularMovieListModel

interface MovieDetailsDataSource {
    suspend fun getMovieDetails(movieId:String): MovieDetailsModel
}