package com.example.moviesapp.domainLayer.usecases.upcomingUc

import com.example.moviesapp.assets.Resource
import com.example.moviesapp.dataLayer.models.popular.PopularMovieListModel
import com.example.moviesapp.dataLayer.models.upcoming.UpcomingMoviesListModel
import kotlinx.coroutines.flow.Flow

interface UpcomingMovieUseCase {
    operator fun invoke(): Flow<Resource<UpcomingMoviesListModel>>
}