package com.example.sdui.data

import com.google.gson.annotations.SerializedName

data class BodyDataDto(
    @SerializedName("banner")
    val banner: BannerDataDto? = null,
    @SerializedName("grid_info")
    val gridInfo: GridInfoDto? = null,
    @SerializedName("design")
    val design: DesignDto? = null,
    @SerializedName("url")
    val url: String? = null,
    @SerializedName("title")
    val title: String? = null,
    @SerializedName("price")
    val price: String? = null,
    @SerializedName("rate")
    val rate: String? = null
)
