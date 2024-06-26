package com.example.moviesapp.domainLayer.repository

import com.example.moviesapp.dataLayer.models.popular.PopularMovieListModel

interface PopularMovieRepository {

    suspend fun getPopularMovieList(): PopularMovieListModel

}