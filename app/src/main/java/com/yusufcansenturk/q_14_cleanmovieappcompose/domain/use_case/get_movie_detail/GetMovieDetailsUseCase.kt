package com.yusufcansenturk.q_14_cleanmovieappcompose.domain.use_case.get_movie_detail

import com.yusufcansenturk.q_14_cleanmovieappcompose.data.remote.dto.toMovieDetail
import com.yusufcansenturk.q_14_cleanmovieappcompose.domain.model.MovieDetail
import com.yusufcansenturk.q_14_cleanmovieappcompose.domain.repository.MovieRepository
import com.yusufcansenturk.q_14_cleanmovieappcompose.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOError
import javax.inject.Inject

class GetMovieDetailsUseCase @Inject constructor(
    private val repository : MovieRepository
    ) {

    fun executeGetMovieDetails(imdbId: String) : Flow<Resource<MovieDetail>> = flow {
        try {
            emit(Resource.Loading())
            val movieDetail = repository.getMovieDetail(imdbId = imdbId).toMovieDetail()
            emit(Resource.Success(movieDetail))
        } catch (e: HttpException) {
            emit(Resource.Error(message = e.localizedMessage ?: "Error!"))
        } catch (e: IOError) {
            emit(Resource.Error(message = "Could not reach internet"))
        }
    }

}