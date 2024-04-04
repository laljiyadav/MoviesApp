package com.example.moviesapp.dataLayer.repositoryImpl

import com.example.moviesapp.dataLayer.datasource.PopularMovieDataSource
import com.example.moviesapp.dataLayer.models.PopularMovieListModel
import com.example.moviesapp.domainLayer.repository.PopularMovieRepository
import javax.inject.Inject

class PopularMovieRepositoryImpl @Inject constructor(private val popularMovieDataSource: PopularMovieDataSource) : PopularMovieRepository {

    override suspend fun getPopularMovieList():PopularMovieListModel {
      return popularMovieDataSource.getPopularMovieList()
    }
}