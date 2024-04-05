package com.example.moviesapp.dataLayer.models.popular

data class PopularMovieListModel(
    val page: Int=0,
    val results: List<Result>?=null,
    val total_pages: Int=0,
    val total_results: Int=0
)