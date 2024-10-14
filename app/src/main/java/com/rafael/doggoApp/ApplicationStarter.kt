package com.rafael.doggoApp

import android.app.Application
import com.rafael.commons.data.di.commonsDataNetworkModule
import com.rafael.doglist.di.dogListModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin


class ApplicationStarter :Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin{
            androidLogger()
            androidContext(this@ApplicationStarter)
            modules(
                commonsDataNetworkModule,
                dogListModule
            )
        }
    }
}
