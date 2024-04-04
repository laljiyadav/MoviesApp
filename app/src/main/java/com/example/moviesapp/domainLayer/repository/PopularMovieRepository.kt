package com.example.moviesapp.domainLayer.repository

import com.example.moviesapp.dataLayer.models.PopularMovieListModel

interface PopularMovieRepository {

    suspend fun getPopularMovieList():PopularMovieListModel

}