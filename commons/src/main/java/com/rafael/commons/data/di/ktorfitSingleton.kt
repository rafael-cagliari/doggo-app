package com.rafael.commons.data.di

import de.jensklingenberg.ktorfit.Ktorfit
import org.kodein.di.DI
import org.kodein.di.bind
import org.kodein.di.singleton

val commonsDataNetworkModule = DI.Module("commonDataNetwork") {
    bind<Ktorfit>() with singleton {
        Ktorfit.Builder()
            .baseUrl("https://api.thedogapi.com/")
            .build()
    }
}