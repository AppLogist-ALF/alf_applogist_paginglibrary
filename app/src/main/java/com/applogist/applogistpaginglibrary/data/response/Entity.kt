package com.applogist.applogistpaginglibrary.data.response

data class Entity(
    val items: List<Item>,
    val pageNumber: Int,
    val pageSize: Int
)