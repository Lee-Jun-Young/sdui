package com.example.sdui.data.dto

import com.google.gson.annotations.SerializedName

data class BannerBodyDto(
    @SerializedName("banner_url")
    val bannerUrl: String? = null,
    @SerializedName("id")
    val id: Int? = null
)

