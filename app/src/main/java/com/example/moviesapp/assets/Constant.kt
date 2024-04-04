package com.example.moviesapp.assets
import android.content.Context
import android.widget.Toast

const val BASE_URL:String="https://api.themoviedb.org/"
const val Authorization:String ="Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiJjZGU4YTliODRhOTRhYWUyZTk2ODM3MmMwYWVmNjA0YSIsInN1YiI6IjU4NWUxYmNhOTI1MTQxMTVjMDAwOGEwMCIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.dwAyXbEjTuftGY9t2Zn-4f4JnREI8AoJ44B6KMi-Bk4"
const val PopularMovie:String =BASE_URL.plus("3/movie/popular?language=en-US&page=1")
fun getHeader():HashMap<String,String>{
    val header=HashMap<String,String>()
    header.put("Authorization",Authorization)
    header.put("accept","application/json")
    return header
}













