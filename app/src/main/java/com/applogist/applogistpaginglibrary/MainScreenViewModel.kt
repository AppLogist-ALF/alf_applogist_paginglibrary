package com.applogist.applogistpaginglibrary

import androidx.lifecycle.ViewModel
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.applogist.applogistpaginglibrary.data.api.ServiceInterface
import com.applogist.applogistpaginglibrary.data.pagingdatasource.ItemPagingSource
import com.applogist.applogistpaginglibrary.data.response.Item
import com.applogist.applogistpaginglibrary.utils.Constant.NETWORK_PAGE_SIZE
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class MainScreenViewModel @Inject constructor(private val serviceInterface: ServiceInterface) : ViewModel() {


    fun fetchList(): Flow<PagingData<Item>> {
        return Pager(config = PagingConfig(pageSize = NETWORK_PAGE_SIZE),
            pagingSourceFactory = { ItemPagingSource(serviceInterface) }
        ).flow
    }

}