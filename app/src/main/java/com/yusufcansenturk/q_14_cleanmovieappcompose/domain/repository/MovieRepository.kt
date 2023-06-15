package com.yusufcansenturk.q_14_cleanmovieappcompose.domain.repository

import com.yusufcansenturk.q_14_cleanmovieappcompose.data.remote.dto.MovieDetailDto
import com.yusufcansenturk.q_14_cleanmovieappcompose.data.remote.dto.MoviesDto

interface MovieRepository {

    suspend fun getMovies(search:String) : MoviesDto

    suspend fun getMovieDetail(imdbId:String) : MovieDetailDto

}