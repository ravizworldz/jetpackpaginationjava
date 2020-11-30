package com.android.paginationapp.network

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface RetroService {

    @GET("character")
    fun getDataFromAPI(@Query("page") query: Int): Call<RickAndMortyList>

}