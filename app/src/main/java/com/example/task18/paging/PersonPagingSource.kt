package com.example.task18.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.task18.network.Api
import com.example.task18.network.model.ResponseModel

class PersonPagingSource(private val api: Api) : PagingSource<Int, ResponseModel.Person>() {

    override fun getRefreshKey(state: PagingState<Int, ResponseModel.Person>): Int? {
        return null
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, ResponseModel.Person> {
        return try {
            val nextPage = params.key ?: 1
            val response = api.getPersons(nextPage)

            LoadResult.Page(
                data = response.data,
                prevKey = if (nextPage == 1) null else nextPage - 1,
                nextKey = if (response.data.isEmpty()) null else nextPage + 1
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }
}