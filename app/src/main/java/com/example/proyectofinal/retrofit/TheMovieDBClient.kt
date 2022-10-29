package com.example.proyectofinal.retrofit

import com.example.proyectofinal.common.Constantes
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class TheMovieDBClient {
    private val theMovieDBService: TheMovieDBService
    private val retrofit: Retrofit

    companion object {
        var instance: TheMovieDBClient? = null
            get() {
                if (field == null) {
                    field = TheMovieDBClient()
                }
                return field
            }
            private set
    }
    init {

        val okHttpClientBuilder = OkHttpClient.Builder()
        okHttpClientBuilder.addInterceptor(TheMovieDBInterceptor())
        val cliente = okHttpClientBuilder.build()
        retrofit = Retrofit.Builder()
            .baseUrl(Constantes.TMDBAPI_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(cliente)
            .build()
        theMovieDBService = retrofit.create(TheMovieDBService::class.java)
    }
    fun getTheMovieDBService() = theMovieDBService
}