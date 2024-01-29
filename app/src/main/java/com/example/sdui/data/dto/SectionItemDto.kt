package com.example.sdui.data.dto

import com.google.gson.annotations.SerializedName

data class SectionItemDto(
    @SerializedName("viewType")
    val viewType: String,
    @SerializedName("design")
    val design: DesignDto? = null
)