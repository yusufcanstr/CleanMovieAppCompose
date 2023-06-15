package com.yusufcansenturk.q_14_cleanmovieappcompose.data.di

import com.yusufcansenturk.q_14_cleanmovieappcompose.data.remote.MovieAPI
import com.yusufcansenturk.q_14_cleanmovieappcompose.data.repository.MovieRepositoryImpl
import com.yusufcansenturk.q_14_cleanmovieappcompose.domain.repository.MovieRepository
import com.yusufcansenturk.q_14_cleanmovieappcompose.util.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideMovieApi(): MovieAPI {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create()
    }

    @Provides
    @Singleton
    fun provideMovieRepository(api: MovieAPI): MovieRepository {
        return MovieRepositoryImpl(api = api)
    }


}