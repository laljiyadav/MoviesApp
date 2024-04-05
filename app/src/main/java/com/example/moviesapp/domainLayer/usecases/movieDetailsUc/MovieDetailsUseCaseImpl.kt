package com.example.moviesapp.domainLayer.usecases.movieDetailsUc

import com.example.moviesapp.assets.Resource
import com.example.moviesapp.dataLayer.models.movieDetails.MovieDetailsModel
import com.example.moviesapp.dataLayer.models.popular.PopularMovieListModel
import com.example.moviesapp.domainLayer.repository.MovieDetailsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOException
import javax.inject.Inject

class MovieDetailsUseCaseImpl @Inject constructor(val movieDetailsRepository: MovieDetailsRepository):MovieDetailsUseCase {

    override fun invoke(movieId:String): Flow<Resource<MovieDetailsModel>> = flow{
        try {

            emit(Resource.Loading())
            var res= movieDetailsRepository.getMovieDetails(movieId)
            val resData: MovieDetailsModel? = if(res!=null) res else null
            emit(Resource.Success(data = resData!!))

        } catch (e: IOException) {
            emit(Resource.Error(message = e.localizedMessage ?: "Check Connectivity"))
        } catch (e: Exception) {
            emit(Resource.Error(message = e.localizedMessage ?: "Check Exception"))
        }
    }
}