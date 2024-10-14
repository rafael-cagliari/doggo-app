package com.rafael.doglist.ui

import androidx.lifecycle.ViewModel
import com.rafael.doglist.data.api.DogsListApi
import com.rafael.doglist.data.model.DogResponse
import kotlinx.coroutines.flow.MutableStateFlow

internal class DogsListViewModel(
    private val api: DogsListApi
): ViewModel() {
    private val _state: MutableStateFlow<List<DogResponse>> = MutableStateFlow(emptyList())
    val state = _state

    suspend fun getDogsList(limit: Int){
        val dogsList = api.searchDogImages(limit)
        _state.value = dogsList
    }
}