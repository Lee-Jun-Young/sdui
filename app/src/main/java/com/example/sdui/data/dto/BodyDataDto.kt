package com.example.sdui.data.dto

import com.google.gson.annotations.SerializedName

data class BodyDataDto(
    @SerializedName("description")
    val description: String? = null,
    @SerializedName("url")
    val url: String? = null,
    @SerializedName("title")
    val title: String? = null,
    @SerializedName("price")
    val price: String? = null,
    @SerializedName("rate")
    val rate: String? = null
)
