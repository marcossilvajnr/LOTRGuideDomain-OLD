package br.com.marcossilvajnr.lotr.guide.domain.model

data class Race(
    val name: String?
) {
    companion object {
        const val DEFAULT_NAME = "Undefined"
    }
}