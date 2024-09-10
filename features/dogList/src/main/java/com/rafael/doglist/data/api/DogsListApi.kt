package com.rafael.doglist.data.api

import com.rafael.doglist.data.model.DogResponse
import de.jensklingenberg.ktorfit.http.GET
import de.jensklingenberg.ktorfit.http.Query

interface DogsListApi {
    @GET("/images/search")
    suspend fun searchDogImages(
        @Query("limit") limit: Int
    ): List<DogResponse>
}