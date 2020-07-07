package br.com.marcossilvajnr.lotr.guide.data.repository

import br.com.marcossilvajnr.lotr.guide.data.datasource.MovieDataSource

class MovieRepository(private val dataSource: MovieDataSource) {
    suspend fun getAllMovies() = dataSource.getAllMovies()
}