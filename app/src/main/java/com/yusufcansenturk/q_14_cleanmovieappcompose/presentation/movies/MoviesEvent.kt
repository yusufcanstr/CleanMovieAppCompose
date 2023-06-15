package com.yusufcansenturk.q_14_cleanmovieappcompose.presentation.movies

sealed class MoviesEvent {
    data class Search(val searchString : String): MoviesEvent()
}