package com.example.moviesapp.dataLayer.datasource

import android.util.Log
import com.devrev.networkclient.Http
import com.devrev.networkclient.JSONObjectListener
import com.example.moviesapp.assets.PopularMovie
import com.example.moviesapp.assets.getHeader
import com.example.moviesapp.dataLayer.models.PopularMovieListModel
import com.google.gson.Gson
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import org.json.JSONObject

interface PopularMovieDataSource {
    suspend fun getPopularMovieList():PopularMovieListModel
}