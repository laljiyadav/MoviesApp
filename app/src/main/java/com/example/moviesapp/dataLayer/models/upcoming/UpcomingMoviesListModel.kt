package com.example.moviesapp.dataLayer.models.upcoming

data class UpcomingMoviesListModel(
    val dates: Dates,
    val page: Int,
    val results: List<Result>,
    val total_pages: Int,
    val total_results: Int
)