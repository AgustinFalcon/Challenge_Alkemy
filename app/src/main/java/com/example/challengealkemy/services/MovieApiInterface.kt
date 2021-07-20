package com.example.challengealkemy.services

import com.example.challengealkemy.models.MovieResponse
import retrofit2.Call
import retrofit2.http.GET

interface MovieApiInterface{

    @GET("/3/movie/popular?api_key=e4ad2f207088006aee58e3bf9ac1e66d")

    fun getMovieList() : Call<MovieResponse>

}