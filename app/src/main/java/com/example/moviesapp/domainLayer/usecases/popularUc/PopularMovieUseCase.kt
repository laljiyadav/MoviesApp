package com.example.moviesapp.domainLayer.usecases.popularUc

import com.example.moviesapp.assets.Resource
import com.example.moviesapp.dataLayer.models.popular.PopularMovieListModel
import kotlinx.coroutines.flow.Flow

interface PopularMovieUseCase {
    operator fun invoke(): Flow<Resource<PopularMovieListModel>>
}