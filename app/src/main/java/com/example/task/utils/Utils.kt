package com.example.task.utils

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.example.task.R

class Utils {
}
    @BindingAdapter("imageBinding")
    fun bindUser(view: ImageView, imageUrl: String?) {
        Glide.with(view.context)
            .load(imageUrl)
            .placeholder(R.drawable.defult_img)
            .into(view)
    }
