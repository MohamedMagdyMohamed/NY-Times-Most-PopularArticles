package com.example.nytimesmostpopulararticles.api.response

import com.google.gson.annotations.SerializedName

open class BaseResponse {
    val status: String = ""

    @SerializedName("copyright")
    val copyRight: String = ""

    @SerializedName("num_results")
    val numResults: Int = 0

    val fault: FaultResponse? = null

    data class FaultResponse(
        @SerializedName("faultstring") val faultString: String,
        val detail: FaultResponseDetail
    )

    data class FaultResponseDetail(
        @SerializedName("errorcode") val errorCode: String
    )
}
