package com.example.moviesapp.dataLayer.repositoryImpl

import com.example.moviesapp.dataLayer.datasource.movieDetailsDs.MovieDetailsDataSource
import com.example.moviesapp.dataLayer.models.movieDetails.MovieDetailsModel
import com.example.moviesapp.domainLayer.repository.MovieDetailsRepository

class MovieDetailsRepositoryImpl constructor( private val movieDetailsDataSource: MovieDetailsDataSource):MovieDetailsRepository {
    override suspend fun getMovieDetails(movieId: String): MovieDetailsModel {
        return movieDetailsDataSource.getMovieDetails(movieId)
    }
}