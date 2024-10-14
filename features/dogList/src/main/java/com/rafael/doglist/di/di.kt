package com.rafael.doglist.di
import com.rafael.doglist.data.api.DogsListApi
import com.rafael.doglist.ui.DogsListViewModel
import de.jensklingenberg.ktorfit.Ktorfit
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val dogListModule = module {
    single<DogsListApi> {
        get<Ktorfit>().create()
    }

    viewModel { DogsListViewModel(api = get<DogsListApi>()) }
}
