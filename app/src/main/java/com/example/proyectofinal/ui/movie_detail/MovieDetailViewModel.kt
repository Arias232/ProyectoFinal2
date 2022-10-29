package com.example.proyectofinal.ui.movie_detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.proyectofinal.repository.TheMovieDBRepository;
import com.example.proyectofinal.retrofit.response.MovieDetailResponse

class MovieDetailViewModel : ViewModel() {
    private var theMovieDBRepository: TheMovieDBRepository
    private lateinit var movie: LiveData<MovieDetailResponse>

    init {
        theMovieDBRepository = TheMovieDBRepository()
    }

    fun getMovie(idMovie: Int): LiveData<MovieDetailResponse>? {
        movie = theMovieDBRepository.getMovie(idMovie)!!
        return  movie
    }
}
