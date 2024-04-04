package com.example.moviesapp.domainLayer.usecases

import com.example.moviesapp.assets.Resource
import com.example.moviesapp.dataLayer.models.PopularMovieListModel
import kotlinx.coroutines.flow.Flow

interface PopularMovieUseCase {
    operator fun invoke(): Flow<Resource<PopularMovieListModel>>
}