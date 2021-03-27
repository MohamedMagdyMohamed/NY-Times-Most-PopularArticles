package com.example.nytimesmostpopulararticles.vo

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Media(
    val type: String,
    @SerializedName("subtype") val subType: String,
    val caption: String,
    @SerializedName("copyright") val copyRight: String,
    @SerializedName("approved_for_syndication") val approvedForSyndication: Boolean,
    @SerializedName("media-metadata") val mediaMetadata: List<MediaMetadata>,
) : Parcelable
