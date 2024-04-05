package com.example.moviesapp.dataLayer.datasource.movieDetailsDs

import android.util.Log
import com.devrev.networkclient.Http
import com.devrev.networkclient.JSONObjectListener
import com.example.moviesapp.assets.LanguageEN
import com.example.moviesapp.assets.MovieDetails
import com.example.moviesapp.assets.PopularMovie
import com.example.moviesapp.assets.getHeader
import com.example.moviesapp.dataLayer.models.movieDetails.MovieDetailsModel
import com.example.moviesapp.dataLayer.models.popular.PopularMovieListModel
import com.google.gson.Gson
import org.json.JSONObject
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine

class MovieDetailsDataSourceImpl : MovieDetailsDataSource {
    override suspend fun getMovieDetails(movieId:String): MovieDetailsModel = suspendCoroutine {
        Http.Request(Http.GET)
            .url(MovieDetails.plus(movieId).plus(LanguageEN))
            .header(getHeader())
            .enableLog(true)
            .execute(object : JSONObjectListener {
                override fun onResponse(res: JSONObject?) {
                    Log.d("MainActivity", res.toString())
                    val movieDetailsModel = Gson().fromJson(res.toString(),
                        MovieDetailsModel::class.java)
                    Log.i("MainActivity", "onResponse: "+movieDetailsModel.homepage)
                    it.resume(movieDetailsModel)
                }
                override fun onFailure(e: Exception?) {
                    Log.d("MainActivity", e.toString())
                    it.resumeWithException(e!!.fillInStackTrace())
                }
            })
    }
}