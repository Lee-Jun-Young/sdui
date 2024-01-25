package com.example.sdui.data.dto

import com.google.gson.annotations.SerializedName

data class DesignDto(
    @SerializedName("top")
    val top: Int,
    @SerializedName("left")
    val left: Int,
    @SerializedName("bottom")
    val bottom: Int,
    @SerializedName("right")
    val right: Int
)
