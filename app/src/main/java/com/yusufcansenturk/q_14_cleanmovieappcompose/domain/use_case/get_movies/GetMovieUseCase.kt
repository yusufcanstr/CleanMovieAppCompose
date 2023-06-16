package com.yusufcansenturk.q_14_cleanmovieappcompose.domain.use_case.get_movies

import com.yusufcansenturk.q_14_cleanmovieappcompose.data.remote.dto.toMovieList
import com.yusufcansenturk.q_14_cleanmovieappcompose.domain.model.Movie
import com.yusufcansenturk.q_14_cleanmovieappcompose.domain.repository.MovieRepository
import com.yusufcansenturk.q_14_cleanmovieappcompose.util.Resource
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOError
import javax.inject.Inject

class GetMovieUseCase @Inject constructor(
    private val repository : MovieRepository
    ) {
    fun executeGetMovies(search: String) : Flow<Resource<List<Movie>>> = flow {
        try {
            emit(Resource.Loading())
            val movieList = repository.getMovies(search)
            if(movieList.Response.equals("True")) {
                emit(Resource.Success(movieList.toMovieList()))
            } else {
                emit(Resource.Error(message = "No movie found"))
            }
        } catch (e: HttpException) {
            emit(Resource.Error(message = e.localizedMessage ?: "Error!"))
        } catch (e: IOError) {
            emit(Resource.Error(message = "Could not reach internet"))
        }
    }

}