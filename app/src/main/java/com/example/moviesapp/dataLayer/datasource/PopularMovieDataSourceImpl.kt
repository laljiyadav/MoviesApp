package com.example.moviesapp.dataLayer.datasource

import android.util.Log
import com.devrev.networkclient.Http
import com.devrev.networkclient.JSONObjectListener
import com.example.moviesapp.assets.PopularMovie
import com.example.moviesapp.assets.getHeader
import com.example.moviesapp.dataLayer.models.PopularMovieListModel
import com.google.gson.Gson
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import org.json.JSONObject
import kotlin.concurrent.thread
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine

class PopularMovieDataSourceImpl : PopularMovieDataSource {

    override suspend fun getPopularMovieList() = suspendCoroutine<PopularMovieListModel> {
        Http.Request(Http.GET)
            .url(PopularMovie)
            .header(getHeader())
            .enableLog(true)
            .execute(object : JSONObjectListener {
                override fun onResponse(res: JSONObject?) {
                    Log.d("MainActivity", res.toString())
                    val popularMovieListModel = Gson().fromJson(res.toString(),PopularMovieListModel::class.java)
                    Log.i("MainActivity", "onResponse: "+popularMovieListModel.page)
                    it.resume(popularMovieListModel)
                }
                override fun onFailure(e: Exception?) {
                    Log.d("MainActivity", e.toString())
                    it.resumeWithException(e!!.fillInStackTrace())
                }
            })

    }

    suspend fun getMovieList() = suspendCoroutine<PopularMovieListModel> {
        Http.Request(Http.GET)
            .url(PopularMovie)
            .header(getHeader())
            .enableLog(true)
            .execute(object : JSONObjectListener {
                override fun onResponse(res: JSONObject?) {
                    Log.d("MainActivity", res.toString())
                   val popularMovieListModel = Gson().fromJson(res.toString(),PopularMovieListModel::class.java)
                    Log.i("MainActivity", "onResponse: "+popularMovieListModel.page)
                    it.resume(popularMovieListModel)
                }
                override fun onFailure(e: Exception?) {
                    Log.d("MainActivity", e.toString())
                    it.resumeWithException(e!!.fillInStackTrace())
                }
            })

    }

}