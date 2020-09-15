package br.com.marcossilvajnr.lotr.guide.data.base

import java.util.*

interface LayerDataMapper<F, T> {
    fun transform(from: F): T
}

abstract class BaseLayerDataTransformer<F, T> : LayerDataMapper<F, T> {
    fun transformToList(from: Collection<F>): List<T?> {
        val transformed: MutableList<T?> = ArrayList(from.size)
        for (fromObject in from) {
            transformed.add(transform(fromObject))
        }
        return transformed
    }
}