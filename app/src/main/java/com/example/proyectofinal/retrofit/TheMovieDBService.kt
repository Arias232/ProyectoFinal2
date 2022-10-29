package com.example.proyectofinal.retrofit

import com.example.proyectofinal.retrofit.response.MovieDetailResponse
import com.example.proyectofinal.retrofit.response.PopularMoviesResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface TheMovieDBService {
    @GET("movie/popular")
    fun getPopularMovies(): Call<PopularMoviesResponse>

    @GET("movie/{movie_id}")
    fun getMovieDetails(@Path("movie_id") movieId: Int): Call<MovieDetailResponse>

}