package com.example.nytimesmostpopulararticles.vo

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class MediaMetadata(
    val url: String,
    val format: String,
    val height: Int,
    val width: Int
) : Parcelable
