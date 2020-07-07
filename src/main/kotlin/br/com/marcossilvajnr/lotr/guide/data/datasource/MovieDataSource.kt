package br.com.marcossilvajnr.lotr.guide.data.datasource

import br.com.marcossilvajnr.lotr.guide.data.models.MoviesBaseResponseModel

interface MovieDataSource {
    suspend fun getAllMovies(): MoviesBaseResponseModel
}