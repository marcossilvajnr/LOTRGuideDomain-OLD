package br.com.marcossilvajnr.lotr.guide.data.models

import java.io.Serializable

open class BaseResponseModel<T>: Serializable {
    val docs: T? = null
}