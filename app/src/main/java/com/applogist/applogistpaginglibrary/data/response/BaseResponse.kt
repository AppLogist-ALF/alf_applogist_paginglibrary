package com.applogist.applogistpaginglibrary.data.response

data class BaseResponse(
    val entity: Entity,
    val error: Error,
    val message: String,
    val success: Boolean
)