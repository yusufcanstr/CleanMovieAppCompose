package com.yusufcansenturk.q_14_cleanmovieappcompose.presentation.movie_detail

import com.yusufcansenturk.q_14_cleanmovieappcompose.domain.model.MovieDetail

data class MovieDetailState(
    val isLoading : Boolean = false,
    val movie : MovieDetail? = null,
    val error: String = ""
)