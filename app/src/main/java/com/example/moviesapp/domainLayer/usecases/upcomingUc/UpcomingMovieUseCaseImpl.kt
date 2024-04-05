package com.example.moviesapp.domainLayer.usecases.upcomingUc

import com.example.moviesapp.assets.Resource
import com.example.moviesapp.dataLayer.models.popular.PopularMovieListModel
import com.example.moviesapp.dataLayer.models.upcoming.UpcomingMoviesListModel
import com.example.moviesapp.domainLayer.repository.UpcomingMoviesRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOException
import javax.inject.Inject

class UpcomingMovieUseCaseImpl @Inject constructor(private val upcomingMoviesRepository: UpcomingMoviesRepository) : UpcomingMovieUseCase {
    override fun invoke(): Flow<Resource<UpcomingMoviesListModel>> = flow {

        try {

            emit(Resource.Loading())
            var res= upcomingMoviesRepository.getUpcomingMovieList()
            val resData: UpcomingMoviesListModel? = if(res!=null) res else null
            emit(Resource.Success(data = resData!!))

        } catch (e: IOException) {
            emit(Resource.Error(message = e.localizedMessage ?: "Check Connectivity"))
        } catch (e: Exception) {
            emit(Resource.Error(message = e.localizedMessage ?: "Check Exception"))
        }
    }
}