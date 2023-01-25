package com.applogist.applogistpaginglibrary.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.applogist.applogistpaginglibrary.data.response.Item
import com.applogist.applogistpaginglibrary.databinding.ItemHeaderLayoutBinding
import com.applogist.applogistpaginglibrary.databinding.ItemLayoutBinding
import com.applogist.applogistpaginglibrary.utils.executeWithAction
import com.applogist.applogistpaginglibrary.utils.loadImage
import retrofit2.http.Header

const val VIEW_TYPE_HEADER = 1
const val VIEW_TYPE_ITEM = 2

class PopularMoviePagingAdapter
constructor(private val itemClick: (Item) -> Unit) :
    PagingDataAdapter<Item, RecyclerView.ViewHolder>(
        DiffUtils
    ) {

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is PopularMovieViewHolder) {
            val popularMovieItem = getItem(position)
            if (popularMovieItem != null) {
                holder.bind(popularMovieItem)
            }
        } else {
            holder as HeaderViewHolder
            val popularMovieItem = getItem(position)
            if (popularMovieItem != null) {
                holder.bind(popularMovieItem)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        if (viewType == VIEW_TYPE_ITEM) {
            return PopularMovieViewHolder(
                ItemLayoutBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                ), itemClick
            )
        }
        return HeaderViewHolder(
            ItemHeaderLayoutBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            ), itemClick
        )
    }

    override fun getItemViewType(position: Int): Int {
        if (position == 0) {
            return VIEW_TYPE_HEADER
        }
        return VIEW_TYPE_ITEM
    }

    class PopularMovieViewHolder(
        private val binding: ItemLayoutBinding,
        private val itemClick: (Item) -> Unit,
    ) :
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

    class HeaderViewHolder(
        private val binding: ItemHeaderLayoutBinding,
        private val itemClick: (Item) -> Unit,
    ) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(result: Item) {
            binding.executeWithAction {
//                this.item = result
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
            newItem: Item,
        ): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(
            oldItem: Item,
            newItem: Item,
        ): Boolean {
            return oldItem == newItem
        }

    }
}