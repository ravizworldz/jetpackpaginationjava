package com.android.paginationapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.android.paginationapp.network.CharacterData
import java.util.concurrent.Executor
import java.util.concurrent.Executors

class MainActivityViewModel() : ViewModel() {

    private var charactersPagedList: LiveData<PagedList<CharacterData>>? = null
    private var executor: Executor? = null

    init {
        initPaging()
    }

    private fun initPaging() {
        val factory = CharacterListDataSourceFactory()

        val config = PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setPageSize(30)
            .build()

        executor= Executors.newFixedThreadPool(5)

        charactersPagedList = LivePagedListBuilder<Int, CharacterData>(factory, config)
            .setFetchExecutor(executor!!)
            .build()

    }

    fun getRecyclerListDataObserver(): LiveData<PagedList<CharacterData>>? {
        return charactersPagedList
    }
}