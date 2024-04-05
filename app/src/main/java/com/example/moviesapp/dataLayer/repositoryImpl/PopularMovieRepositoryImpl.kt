package com.example.moviesapp.dataLayer.repositoryImpl

import com.example.moviesapp.dataLayer.datasource.popularDs.PopularMovieDataSource
import com.example.moviesapp.dataLayer.models.popular.PopularMovieListModel
import com.example.moviesapp.domainLayer.repository.PopularMovieRepository
import javax.inject.Inject

class PopularMovieRepositoryImpl @Inject constructor(private val popularMovieDataSource: PopularMovieDataSource) : PopularMovieRepository {

    override suspend fun getPopularMovieList(): PopularMovieListModel {
      return popularMovieDataSource.getPopularMovieList()
    }
}