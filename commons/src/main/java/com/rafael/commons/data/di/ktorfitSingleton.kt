package com.rafael.commons.data.di

import de.jensklingenberg.ktorfit.Ktorfit
import io.ktor.client.HttpClient
import io.ktor.client.engine.okhttp.OkHttp
import io.ktor.client.plugins.DefaultRequest
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.header
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import org.koin.dsl.module

val commonsDataNetworkModule = module {

    single<HttpClient>{
        HttpClient(OkHttp){
            install(ContentNegotiation){
                json(
                    Json {
                        ignoreUnknownKeys = true
                        isLenient = true
                    }
                )
            }
            install(DefaultRequest){
                header("x-api-key", "add api key here")
            }
        }
    }

    single<Ktorfit> {
        Ktorfit.Builder()
            .baseUrl("https://api.thedogapi.com/v1/")
            .httpClient(get<HttpClient>())
            .build()
    }
}