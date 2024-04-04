package com.example.moviesapp.domainLayer.usecases

import com.example.moviesapp.assets.Resource
import com.example.moviesapp.dataLayer.models.PopularMovieListModel
import com.example.moviesapp.domainLayer.repository.PopularMovieRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOException
import javax.inject.Inject

class PopularMovieUseCaseImpl @Inject constructor (private val popularMovieRepository: PopularMovieRepository):
    PopularMovieUseCase {


    override fun invoke(): Flow<Resource<PopularMovieListModel>> = flow {
        try {

            emit(Resource.Loading())
            var res= popularMovieRepository.getPopularMovieList()
            val resData: PopularMovieListModel? = if(res!=null) res else null
            emit(Resource.Success(data = resData!!))

        } catch (e: IOException) {
            emit(Resource.Error(message = e.localizedMessage ?: "Check Connectivity"))
        } catch (e: Exception) {
            emit(Resource.Error(message = e.localizedMessage ?: "Check Exception"))
        }
    }
}