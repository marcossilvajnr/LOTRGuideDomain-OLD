package br.com.marcossilvajnr.lotr.guide.framework.api

import br.com.marcossilvajnr.lotr.guide.data.datasource.MovieDataSource
import br.com.marcossilvajnr.lotr.guide.data.models.MoviesBaseResponseModel
import io.ktor.client.HttpClient
import io.ktor.client.request.get

class MovieApi (
    private val client: HttpClient
): MovieDataSource {

    override suspend fun getAllMovies() = client.get<MoviesBaseResponseModel> {
        url { encodedPath = "/v1/movie" }
    }
}