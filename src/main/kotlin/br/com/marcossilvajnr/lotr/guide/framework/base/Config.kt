package br.com.marcossilvajnr.lotr.guide.framework.base

import io.ktor.client.HttpClient
import io.ktor.client.engine.cio.CIO
import io.ktor.client.engine.cio.endpoint
import io.ktor.client.features.defaultRequest
import io.ktor.client.features.json.JsonFeature
import io.ktor.client.features.logging.DEFAULT
import io.ktor.client.features.logging.LogLevel
import io.ktor.client.features.logging.Logger
import io.ktor.client.features.logging.Logging
import io.ktor.client.request.header
import io.ktor.client.request.host
import io.ktor.util.KtorExperimentalAPI

@KtorExperimentalAPI
val defaultCIOHttpClient = HttpClient(CIO) {
    install(JsonFeature)
    install(Logging) {
        logger = Logger.DEFAULT
        level = LogLevel.ALL
    }

    engine {
        maxConnectionsCount = 1000

        endpoint {
            maxConnectionsPerRoute = 100
            pipelineMaxSize = 20
            keepAliveTime = 5000
            connectTimeout = 5000
            connectRetryAttempts = 5
        }
    }

    defaultRequest {
        host = "the-one-api.herokuapp.com"
        header("accept", "application/json")
        header("charset", "utf-8")
        header("Authorization", "Bearer agkbAVvUvLzTtrjyLYob")
    }
}