package com.rafael.commons.data.network

import org.kodein.di.DI
import org.kodein.di.bind
import org.kodein.di.singleton
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val commonsDataNetworkModule = DI.Module("commonDataNetwork") {
    bind<Retrofit>() with singleton {
        Retrofit.Builder()
            .baseUrl("https://api.thedogapi.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}