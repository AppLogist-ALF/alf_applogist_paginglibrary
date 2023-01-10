package com.applogist.applogistpaginglibrary.utils

import android.view.View
import android.widget.ImageView
import com.applogist.applogistpaginglibrary.R
import com.bumptech.glide.Glide


fun View.setGone() {
    this.visibility = View.GONE
}

fun View.setVisible() {
    this.visibility = View.VISIBLE
}


fun ImageView.loadImage(imageUrl: String?) {
    Glide.with(this.context)
        .load(imageUrl)
        .error(R.color.purple_200)
        .into(this)
}
