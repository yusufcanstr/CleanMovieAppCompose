package com.yusufcansenturk.q_14_cleanmovieappcompose.data.remote.dto

data class MoviesDto(
    val Response: String,
    val Search: List<Search>,
    val totalResults: String
)