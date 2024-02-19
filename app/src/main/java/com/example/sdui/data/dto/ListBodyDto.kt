package com.example.sdui.data.dto

import com.google.gson.annotations.SerializedName

data class ListBodyDto(
    @SerializedName("title")
    val title: String? = null,
    @SerializedName("id")
    val id: String? = null,
    @SerializedName("description")
    val description: String? = null,
    @SerializedName("url")
    val url: String? = null,
    @SerializedName("price")
    val price: String? = null,
    @SerializedName("rate")
    val rate: String? = null
)