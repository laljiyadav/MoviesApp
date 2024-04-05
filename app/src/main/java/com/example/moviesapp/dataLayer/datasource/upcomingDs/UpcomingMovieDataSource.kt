package com.example.moviesapp.dataLayer.datasource.upcomingDs

import com.example.moviesapp.dataLayer.models.upcoming.UpcomingMoviesListModel

interface UpcomingMovieDataSource {
    suspend fun getUpcomingMovieList(): UpcomingMoviesListModel
}