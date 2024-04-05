package com.example.moviesapp.diModule

import com.example.moviesapp.assets.BASE_URL
import com.example.moviesapp.dataLayer.datasource.movieDetailsDs.MovieDetailsDataSource
import com.example.moviesapp.dataLayer.datasource.movieDetailsDs.MovieDetailsDataSourceImpl
import com.example.moviesapp.dataLayer.datasource.popularDs.PopularMovieDataSource
import com.example.moviesapp.dataLayer.datasource.popularDs.PopularMovieDataSourceImpl
import com.example.moviesapp.dataLayer.datasource.upcomingDs.UpcomingMovieDataSource
import com.example.moviesapp.dataLayer.datasource.upcomingDs.UpcomingMovieDataSourceImpl
import com.example.moviesapp.dataLayer.repositoryImpl.MovieDetailsRepositoryImpl
import com.example.moviesapp.dataLayer.repositoryImpl.PopularMovieRepositoryImpl
import com.example.moviesapp.dataLayer.repositoryImpl.UpcomingMoviesRepositoryImpl
import com.example.moviesapp.domainLayer.repository.MovieDetailsRepository
import com.example.moviesapp.domainLayer.repository.PopularMovieRepository
import com.example.moviesapp.domainLayer.repository.UpcomingMoviesRepository
import com.example.moviesapp.domainLayer.usecases.movieDetailsUc.MovieDetailsUseCase
import com.example.moviesapp.domainLayer.usecases.movieDetailsUc.MovieDetailsUseCaseImpl
import com.example.moviesapp.domainLayer.usecases.popularUc.PopularMovieUseCase
import com.example.moviesapp.domainLayer.usecases.popularUc.PopularMovieUseCaseImpl
import com.example.moviesapp.domainLayer.usecases.upcomingUc.UpcomingMovieUseCase
import com.example.moviesapp.domainLayer.usecases.upcomingUc.UpcomingMovieUseCaseImpl
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
    fun providePopularMovieRepositoryUseCase(popularMovieRepository: PopularMovieRepository): PopularMovieUseCase =
        PopularMovieUseCaseImpl(popularMovieRepository)

    @Provides
    fun provideUpcomingMovieDataSource():UpcomingMovieDataSource =UpcomingMovieDataSourceImpl()
    @Provides
    fun provideUpcomingMovieRepository(upcomingMovieDataSource: UpcomingMovieDataSource):UpcomingMoviesRepository = UpcomingMoviesRepositoryImpl(upcomingMovieDataSource)

    @Provides
    fun provideUpcomingMovieUseCase(upcomingMoviesRepository: UpcomingMoviesRepository):UpcomingMovieUseCase = UpcomingMovieUseCaseImpl(upcomingMoviesRepository)

    @Provides
    fun provideMovieDetailsDataSource():MovieDetailsDataSource =MovieDetailsDataSourceImpl()
    @Provides
    fun provideMovieDetailsRepository(movieDetailsDataSource: MovieDetailsDataSource):MovieDetailsRepository = MovieDetailsRepositoryImpl(movieDetailsDataSource)

    @Provides
    fun  provideMovieDetailsUseCase(movieDetailsRepository: MovieDetailsRepository): MovieDetailsUseCase = MovieDetailsUseCaseImpl(movieDetailsRepository)




}