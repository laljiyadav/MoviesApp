package com.example.moviesapp.dataLayer.datasource.popularDs

import com.example.moviesapp.dataLayer.models.popular.PopularMovieListModel

interface PopularMovieDataSource {
    suspend fun getPopularMovieList(): PopularMovieListModel
}