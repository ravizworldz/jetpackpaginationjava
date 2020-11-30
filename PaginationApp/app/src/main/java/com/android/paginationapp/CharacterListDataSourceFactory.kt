package com.android.paginationapp

import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import com.android.paginationapp.network.CharacterData

class CharacterListDataSourceFactory() : DataSource.Factory<Int, CharacterData>()  {

    private var mutableLiveData: MutableLiveData<CharacterListDataSource>? = null

    init {
        mutableLiveData = MutableLiveData<CharacterListDataSource>()
    }

    override fun create(): DataSource<Int, CharacterData> {
        val listDataSource = CharacterListDataSource()
        mutableLiveData?.postValue(listDataSource);
        return listDataSource
    }
}