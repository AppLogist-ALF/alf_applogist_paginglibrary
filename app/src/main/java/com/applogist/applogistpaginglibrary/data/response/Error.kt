package com.applogist.applogistpaginglibrary.data.response

data class Error(
    val code: Int,
    val debugMessage: String,
    val message: String
)