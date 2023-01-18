package com.applogist.applogistpaginglibrary.adapter

import androidx.recyclerview.widget.RecyclerView
import com.applogist.applogistpaginglibrary.data.response.Item
import com.applogist.applogistpaginglibrary.databinding.ItemLayoutBinding
import com.applogist.applogistpaginglibrary.utils.executeWithAction
import com.applogist.applogistpaginglibrary.utils.loadImage

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