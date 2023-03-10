package com.applogist.applogistpaginglibrary.utils

import android.widget.ImageView
import androidx.databinding.BindingAdapter

object BindingUtils {

    @JvmStatic
    @BindingAdapter("load_image")
    fun loadImage(view: ImageView, imageUrl: String?) {
        imageUrl?.let {
            view.loadImage(it)
        }
    }
}