package com.example.task18.screens.fragments

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.example.task18.network.Api
import com.example.task18.paging.PersonPagingSource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val api: Api) : ViewModel() {
    val personsList = Pager(PagingConfig(pageSize = 10)) {
        PersonPagingSource(api)
    }.flow.cachedIn(viewModelScope)
}