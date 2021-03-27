package com.example.nytimesmostpopulararticles.vo

import com.google.gson.annotations.SerializedName

data class Media(
    val type: String,
    @SerializedName("subtype") val subType: String,
    val caption: String,
    @SerializedName("copyright") val copyRight: String,
    @SerializedName("approved_for_syndication") val approvedForSyndication: Boolean,
    @SerializedName("media-metadata") val mediaMetadata: List<MediaMetadata>,
)
