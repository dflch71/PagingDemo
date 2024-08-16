package com.dflch.pagingdemo.presentation

import androidx.lifecycle.ViewModel
import androidx.paging.PagingData
import com.dflch.pagingdemo.data.RickRepository
import com.dflch.pagingdemo.presentation.model.CharacterModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class RickListViewModel @Inject constructor(rickRepository: RickRepository) : ViewModel() {
    val characters:  Flow<PagingData<CharacterModel>> = rickRepository.getAllCharacters()
}