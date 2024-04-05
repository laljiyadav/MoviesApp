package com.example.moviesapp.domainLayer.repository

import com.example.moviesapp.dataLayer.models.upcoming.UpcomingMoviesListModel

interface UpcomingMoviesRepository {

    suspend fun getUpcomingMovieList():UpcomingMoviesListModel

}