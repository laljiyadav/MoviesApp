package com.example.moviesapp.dataLayer.repositoryImpl

import com.example.moviesapp.dataLayer.datasource.upcomingDs.UpcomingMovieDataSource
import com.example.moviesapp.dataLayer.models.upcoming.UpcomingMoviesListModel
import com.example.moviesapp.domainLayer.repository.UpcomingMoviesRepository
import javax.inject.Inject

class UpcomingMoviesRepositoryImpl @Inject constructor(val upcomingMovieDataSource: UpcomingMovieDataSource): UpcomingMoviesRepository {
    override suspend fun getUpcomingMovieList(): UpcomingMoviesListModel {
        return upcomingMovieDataSource.getUpcomingMovieList()
    }
}