package com.example.nytimesmostpopulararticles.utils.viewsextension

import android.graphics.drawable.Drawable
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.example.nytimesmostpopulararticles.utils.GlideApp

@BindingAdapter("imageUrl", "placeholder", "isCircular", requireAll = false)
fun ImageView.loadImage(
    imageUrl: String?,
    placeholderDrawable: Drawable? = null,
    isCircular: Boolean = false
) {
    Glide.get(context)
    val glideRequest = GlideApp.with(context)
        .load(imageUrl ?: "")
        .centerCrop()

    placeholderDrawable?.let { drawable ->
        glideRequest.placeholder(drawable)
    }

    if (isCircular) glideRequest.circleCrop()

    glideRequest.into(this)
}
