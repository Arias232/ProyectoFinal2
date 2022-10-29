package com.example.proyectofinal.ui.movies
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.proyectofinal.repository.TheMovieDBRepository
import com.example.proyectofinal.retrofit.response.Movie


class MoviesViewModel : ViewModel() {
    private var theMovieDBRepository: TheMovieDBRepository
    private var popularMovies: LiveData<List<Movie>>
    val selectedMovie: MutableLiveData<Int> by lazy {
        MutableLiveData<Int>()
    }

    init {
        theMovieDBRepository = TheMovieDBRepository()
        popularMovies = theMovieDBRepository.popularMovies()!!
    }

    fun getPopularMovies(): LiveData<List<Movie>>? {
        if(selectedMovie == null) selectedMovie.setValue(popularMovies.value?.get(0)?.id)
        return popularMovies
    }

}