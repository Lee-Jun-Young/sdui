package com.example.sdui.data

import com.google.gson.annotations.SerializedName

data class SectionItemListDto(
    @SerializedName("viewType")
    val viewType: String,
    @SerializedName("header")
    val header: HeaderDataDto? = null,
    @SerializedName("body")
    val body: BodyDataDto? = null
)