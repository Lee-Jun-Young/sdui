package com.example.sdui.data

import com.google.gson.annotations.SerializedName

data class BannerDataDto(
    @SerializedName("url")
    val url: String? = null,
    @SerializedName("title")
    val title: String? = null,
    @SerializedName("description")
    val description: String? = null
)
