package com.yusufcansenturk.q_14_cleanmovieappcompose.data.repository

import com.yusufcansenturk.q_14_cleanmovieappcompose.data.remote.MovieAPI
import com.yusufcansenturk.q_14_cleanmovieappcompose.data.remote.dto.MovieDetailDto
import com.yusufcansenturk.q_14_cleanmovieappcompose.data.remote.dto.MoviesDto
import com.yusufcansenturk.q_14_cleanmovieappcompose.domain.repository.MovieRepository
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(
    private val api : MovieAPI
    ) : MovieRepository {
    override suspend fun getMovies(search: String): MoviesDto {
        return api.getMovies(searchString = search)
    }
    override suspend fun getMovieDetail(imdbId: String): MovieDetailDto {
        return api.getMovieDetail(imdbId = imdbId)
    }
}