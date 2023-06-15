package com.yusufcansenturk.q_14_cleanmovieappcompose.data.remote

import com.yusufcansenturk.q_14_cleanmovieappcompose.data.remote.dto.MovieDetailDto
import com.yusufcansenturk.q_14_cleanmovieappcompose.data.remote.dto.MoviesDto
import com.yusufcansenturk.q_14_cleanmovieappcompose.util.Constants.API_KEY
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieAPI {

    //http://www.omdbapi.com/?apikey=f30decb3&i=tt0372784
    //http://www.omdbapi.com/?apikey=f30decb3&s=batman

    @GET(".")
    suspend fun getMovies(
        @Query("s") searchString: String,
        @Query("apikey") apiKey: String = API_KEY
    ) : MoviesDto

    @GET(".")
    suspend fun getMovieDetail(
        @Query("i") imdbId: String,
        @Query("apikey") apiKey: String = API_KEY
    ) : MovieDetailDto

}