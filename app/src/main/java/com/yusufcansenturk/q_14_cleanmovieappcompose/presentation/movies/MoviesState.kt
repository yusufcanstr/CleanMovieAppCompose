package com.yusufcansenturk.q_14_cleanmovieappcompose.presentation.movies

import com.yusufcansenturk.q_14_cleanmovieappcompose.domain.model.Movie

data class MoviesState(
    val isLoading: Boolean = false,
    val movies : List<Movie> = emptyList(),
    val error: String = "",
    val search : String = "iron man"
)