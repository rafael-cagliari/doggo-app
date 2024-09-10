package com.rafael.doglist.di

import android.app.Activity
import com.rafael.doglist.data.api.DogsListApi
import de.jensklingenberg.ktorfit.Ktorfit
import org.kodein.di.DI
import org.kodein.di.bind
import org.kodein.di.bindings.WeakContextScope
import org.kodein.di.instance
import org.kodein.di.scoped
import org.kodein.di.singleton

val dogListModule = DI.Module("dogListModule") {
    bind<DogsListApi> { scoped(WeakContextScope.of<Activity>()).singleton {
        instance<Ktorfit>().create()
    }
} }
