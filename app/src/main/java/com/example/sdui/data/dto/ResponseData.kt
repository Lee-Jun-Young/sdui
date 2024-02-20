package com.example.sdui.data.dto

import com.google.gson.annotations.SerializedName

data class ResponseDataDto(
    @SerializedName("static_area")
    val staticArea: AreaDto? = null,
    @SerializedName("dynamic_area")
    val dynamicArea: AreaDto? = null
)

data class AreaDto(
    val sections: List<BaseBodyDto>? = null
)

interface BaseBodyDto {
    val viewType: String
}

data class SectionCardDto(
    override val viewType: String = "VIEW_TYPE_CARD",
    val title: String? = null,
    val id: Int? = null,
    val url: String? = null,
    val description: String? = null,
    val price: String? = null
) : BaseBodyDto

data class SectionBannerDto(
    override val viewType: String = "VIEW_TYPE_BANNER",
    val title: String? = null,
    val body: List<BannerBodyDto>? = null
) : BaseBodyDto

data class SectionAppBarDto(
    override val viewType: String = "VIEW_TYPE_APP_BAR",
    val title: String? = null,
) : BaseBodyDto

data class SectionListDto(
    override val viewType: String = "VIEW_TYPE_LIST",
    val design: DesignDto? = null,
    val body: List<ListBodyDto>? = null
) : BaseBodyDto