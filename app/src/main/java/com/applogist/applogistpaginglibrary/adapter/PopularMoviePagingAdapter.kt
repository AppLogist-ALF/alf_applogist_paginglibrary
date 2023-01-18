package com.applogist.applogistpaginglibrary.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import com.applogist.applogistpaginglibrary.data.response.Item
import com.applogist.applogistpaginglibrary.databinding.ItemLayoutBinding

class PopularMoviePagingAdapter
constructor(private val itemClick: (Item) -> Unit) :
    PagingDataAdapter<Item, PopularMovieViewHolder>(
        DiffUtils
    ) {

    override fun onBindViewHolder(holder: PopularMovieViewHolder, position: Int) {
        val popularMovieItem = getItem(position)
        if (popularMovieItem != null) {
            holder.bind(popularMovieItem)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PopularMovieViewHolder {
        return PopularMovieViewHolder(
            ItemLayoutBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            ), itemClick
        )
    }

    object DiffUtils : DiffUtil.ItemCallback<Item>() {
        override fun areItemsTheSame(
            oldItem: Item,
            newItem: Item
        ): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(
            oldItem: Item,
            newItem: Item
        ): Boolean {
            return oldItem == newItem
        }

    }
}