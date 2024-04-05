package com.example.moviesapp.dataLayer.datasource.upcomingDs

import android.util.Log
import com.devrev.networkclient.Http
import com.devrev.networkclient.JSONObjectListener
import com.example.moviesapp.assets.PopularMovie
import com.example.moviesapp.assets.getHeader
import com.example.moviesapp.dataLayer.models.popular.PopularMovieListModel
import com.example.moviesapp.dataLayer.models.upcoming.UpcomingMoviesListModel
import com.google.gson.Gson
import org.json.JSONObject
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine

class UpcomingMovieDataSourceImpl :UpcomingMovieDataSource {
    override suspend fun getUpcomingMovieList() = suspendCoroutine<UpcomingMoviesListModel> {
        Http.Request(Http.GET)
            .url(PopularMovie)
            .header(getHeader())
            .enableLog(true)
            .execute(object : JSONObjectListener {
                override fun onResponse(res: JSONObject?) {
                    Log.d("MainActivity", res.toString())
                    val upcomingMoviesListModel = Gson().fromJson(
                        res.toString(),
                        UpcomingMoviesListModel::class.java
                    )
                    Log.i("MainActivity", "onResponse: " + upcomingMoviesListModel.page)
                    it.resume(upcomingMoviesListModel)
                }

                override fun onFailure(e: Exception?) {
                    Log.d("MainActivity", e.toString())
                    it.resumeWithException(e!!.fillInStackTrace())
                }
            })
    }
}