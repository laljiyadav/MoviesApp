package com.example.moviesapp.domainLayer.repository

import com.example.moviesapp.dataLayer.models.movieDetails.MovieDetailsModel
import com.example.moviesapp.dataLayer.models.popular.PopularMovieListModel

interface MovieDetailsRepository {
    suspend fun getMovieDetails(movieId:String): MovieDetailsModel

}