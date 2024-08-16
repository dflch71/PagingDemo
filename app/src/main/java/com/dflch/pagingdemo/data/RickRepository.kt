package com.dflch.pagingdemo.data

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.dflch.pagingdemo.presentation.model.CharacterModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class RickRepository @Inject constructor(
    private val apiService: RickMortyApiService
) {
    companion object {
        const val MAX_ITEM = 10
        const val PREFETCH_ITEM = 3
    }

    fun getAllCharacters(): Flow<PagingData<CharacterModel>>{
        return Pager(config = PagingConfig(pageSize = MAX_ITEM, prefetchDistance = PREFETCH_ITEM),
            pagingSourceFactory = { CharacterPagingSource(apiService) }).flow
    }

}