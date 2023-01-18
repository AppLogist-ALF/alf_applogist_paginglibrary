package com.applogist.applogistpaginglibrary.data.api

import com.applogist.applogistpaginglibrary.data.response.BaseResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ServiceInterface {

    @GET("/api/Item/Items")
    suspend fun fetchUpComing(
        @Query("pageNumber") pageNumber: Int
    ) : BaseResponse


}