package com.rafael.commons.data.di

import de.jensklingenberg.ktorfit.Ktorfit
import io.ktor.client.HttpClient
import io.ktor.client.engine.okhttp.OkHttp
import io.ktor.client.plugins.DefaultRequest
import io.ktor.client.request.header

import org.kodein.di.DI
import org.kodein.di.bind
import org.kodein.di.singleton

private val client = HttpClient(OkHttp) {
    install(DefaultRequest) {
        header("x-api-key", "live_8GzkAZvkPmSDdG6GwKhn76Ap34OHWEWsaF4nmtcMIWeqr9gvCMnYVpV32JRfCCbj")
    }
}

val commonsDataNetworkModule = DI.Module("commonDataNetwork") {
    bind<Ktorfit>() with singleton {
        Ktorfit.Builder()
            .baseUrl("https://api.thedogapi.com/v1")
            .httpClient(client)
            .build()
    }
}