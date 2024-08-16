package com.dflch.pagingdemo.data

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.dflch.pagingdemo.presentation.model.CharacterModel
import javax.inject.Inject

class CharacterPagingSource @Inject constructor(private val apiService: RickMortyApiService) :
    PagingSource<Int, CharacterModel>() {
    override fun getRefreshKey(state: PagingState<Int, CharacterModel>): Int? {
        return state.anchorPosition
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, CharacterModel> {

        return try {

            val nextPage = params.key ?: 1
            val response = apiService.getCharacters(nextPage)
            val characters = response.results

            val prevKey: Int? = if (nextPage == 1) null else nextPage - 1
            val nextKey: Int? = if (characters.isEmpty()) null else nextPage + 1
            LoadResult.Page(data = characters.map { it.toCharacterModel() }, prevKey = prevKey, nextKey = nextKey)

        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }
}