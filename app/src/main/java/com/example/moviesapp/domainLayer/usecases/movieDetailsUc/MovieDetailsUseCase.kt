package com.example.moviesapp.domainLayer.usecases.movieDetailsUc

import com.example.moviesapp.assets.Resource
import com.example.moviesapp.dataLayer.models.movieDetails.MovieDetailsModel
import com.example.moviesapp.dataLayer.models.popular.PopularMovieListModel
import kotlinx.coroutines.flow.Flow

interface MovieDetailsUseCase {
    operator fun invoke(movieId:String): Flow<Resource<MovieDetailsModel>>
}