package com.example.moviesapp.dataLayer.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

data class PopularMovieListModel(
    val page: Int=0,
    val results: List<Result>?=null,
    val total_pages: Int=0,
    val total_results: Int=0
)