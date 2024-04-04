package com.example.moviesapp.diModule

import com.example.moviesapp.assets.BASE_URL
import com.example.moviesapp.dataLayer.datasource.PopularMovieDataSource
import com.example.moviesapp.dataLayer.datasource.PopularMovieDataSourceImpl
import com.example.moviesapp.dataLayer.repositoryImpl.PopularMovieRepositoryImpl
import com.example.moviesapp.domainLayer.repository.PopularMovieRepository
import com.example.moviesapp.domainLayer.usecases.PopularMovieUseCase
import com.example.moviesapp.domainLayer.usecases.PopularMovieUseCaseImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object DIModule {

    @Provides
    fun provideBaseUrl() = BASE_URL

    @Provides
    fun providePopularMovieDataSource(): PopularMovieDataSource = PopularMovieDataSourceImpl()

    @Provides
    fun providePopularMovieRepository(popularMovieDataSource: PopularMovieDataSource): PopularMovieRepository = PopularMovieRepositoryImpl(popularMovieDataSource)

    @Provides
    fun providePopularMovieRepositoryUseCase(popularMovieRepository: PopularMovieRepository): PopularMovieUseCase =PopularMovieUseCaseImpl(popularMovieRepository)



}