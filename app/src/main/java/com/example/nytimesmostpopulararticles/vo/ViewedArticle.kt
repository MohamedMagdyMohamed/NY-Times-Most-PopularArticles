package com.example.nytimesmostpopulararticles.vo

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import java.util.Date

@Parcelize
data class ViewedArticle(
    val url: String,
    @SerializedName("adx_keywords") val adxKeywords: String,
    val column: String,
    val section: String,
    @SerializedName("byline") val byLine: String,
    val type: String,
    val title: String,
    val abstract: String,
    @SerializedName("published_date") val publishedDate: Date,
    val source: String,
    val id: Long,
    @SerializedName("asset_id") val assetId: Long,
    val views: Int,
    @SerializedName("des_facet") val desFacet: List<String>,
    @SerializedName("org_facet") val orgFacet: List<String>,
    @SerializedName("per_facet") val perFacet: List<String>,
    @SerializedName("geo_facet") val geoFacet: List<String>,
    val media: List<Media>,
    val uri: String
) : Parcelable {

    fun getImageUrl(): String {
        if (media.isNotEmpty() && media[0].mediaMetadata.isNotEmpty()) {
            return media[0].mediaMetadata[media[0].mediaMetadata.size - 1].url
        }
        return ""
    }
}
