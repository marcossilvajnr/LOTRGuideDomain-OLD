package br.com.marcossilvajnr.lotr.guide.data.models

class MoviesBaseResponseModel: BaseResponseModel<List<MovieResponseModel>>()

data class MovieResponseModel(
    val _id: String?,
    val academyAwardNominations: Int?,
    val academyAwardWins: Int?,
    val boxOfficeRevenueInMillions: Float?,
    val budgetInMillions: Float?,
    val name: String?,
    val runtimeInMinutes: Float?
)