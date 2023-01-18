package com.applogist.applogistpaginglibrary.data.pagingdatasource

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.applogist.applogistpaginglibrary.data.api.ServiceInterface
import com.applogist.applogistpaginglibrary.data.response.Item
import javax.inject.Inject

class ItemPagingSource @Inject constructor(
    private val serviceInterface: ServiceInterface
) : PagingSource<Int, Item>() {

    override fun getRefreshKey(state: PagingState<Int, Item>): Int {
        return 1
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Item> {
        var pageIndex = 1
        if (params.key != null) {
            pageIndex = params.key!!
        }
        val response = serviceInterface.fetchUpComing(pageNumber = pageIndex)

        return if (response.entity?.items?.isNotEmpty() == true) {
            pageIndex++
            LoadResult.Page(
                data = response.entity.items,
                prevKey = null,
                nextKey = pageIndex
            )
        } else {
            LoadResult.Page(
                data = arrayListOf(),
                prevKey = null,
                nextKey = null
            )
        }
    }
}