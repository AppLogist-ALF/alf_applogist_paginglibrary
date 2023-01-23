package com.applogist.applogistpaginglibrary.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.applogist.applogistpaginglibrary.data.response.Item
import com.applogist.applogistpaginglibrary.databinding.ItemLayoutBinding
import com.applogist.applogistpaginglibrary.utils.executeWithAction
import com.applogist.applogistpaginglibrary.utils.loadImage

class PopularMoviePagingAdapter
constructor(private val itemClick: (Item) -> Unit) :
    PagingDataAdapter<Item, PopularMoviePagingAdapter.PopularMovieViewHolder>(
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

    class PopularMovieViewHolder(private val binding: ItemLayoutBinding, private val itemClick: (Item) -> Unit) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(result: Item) {
            binding.executeWithAction {
                this.item = result
            }
            binding.popularMovieImageView.loadImage(result.imageUrl)
//        binding.textViewRelease.text = "(" +result.release_date?.split("-")?.get(0) + ")"
//        var date = result.release_date?.split("-")
//        binding.releaseDate.text = date?.get(2) + "." + date?.get(1) + "." + date?.get(0)
//        binding.root.setOnClickListener {
//            itemClick.invoke(result)
//        }
        }
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