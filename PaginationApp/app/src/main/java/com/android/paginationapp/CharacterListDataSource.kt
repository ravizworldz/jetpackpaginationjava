package com.android.paginationapp

import androidx.paging.PageKeyedDataSource
import com.android.paginationapp.network.CharacterData
import com.android.paginationapp.network.RickAndMortyList
import com.android.paginationapp.network.RetroInstance
import com.android.paginationapp.network.RetroService
import retrofit2.Call
import retrofit2.Response

class CharacterListDataSource() : PageKeyedDataSource<Int, CharacterData>()  {

    override fun loadInitial(params: LoadInitialParams<Int>, callback: LoadInitialCallback<Int, CharacterData>) {
        val retroInstance = RetroInstance.getRetroInstance().create(RetroService::class.java)
        val call = retroInstance.getDataFromAPI(1)
        call.enqueue(object : retrofit2.Callback<RickAndMortyList>{
            override fun onResponse(call: Call<RickAndMortyList>, response: Response<RickAndMortyList>) {
                if(response.isSuccessful) {
                    callback.onResult(response?.body()?.results!!, null, 2)
                }
            }

            override fun onFailure(call: Call<RickAndMortyList>, t: Throwable) {
            }
        })
    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, CharacterData>) {
        val retroInstance = RetroInstance.getRetroInstance().create(RetroService::class.java)
        val call = retroInstance.getDataFromAPI(params.key)
        call.enqueue(object : retrofit2.Callback<RickAndMortyList>{
            override fun onResponse(call: Call<RickAndMortyList>, response: Response<RickAndMortyList>) {
                if(response.isSuccessful) {
                    callback.onResult(response?.body()?.results!!, params.key + 1)
                }
            }

            override fun onFailure(call: Call<RickAndMortyList>, t: Throwable) {
            }
        })
    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, CharacterData>) {

    }
}
















