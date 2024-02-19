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
    val body: SectionCardContentDto? = null
) : BaseBodyDto

data class SectionCardContentDto(
    val title: String? = null,
    val id: Int? = null,
    val url: String? = null,
    val description: String? = null,
    val price: String? = null
)

data class SectionBannerDto(
    override val viewType: String = "VIEW_TYPE_BANNER",
    val body: SectionBannerContentDto? = null
) : BaseBodyDto

data class SectionBannerContentDto(
    val title: String? = null,
    val body: List<BannerBodyDto>? = null
)

data class SectionAppBarDto(
    override val viewType: String = "VIEW_TYPE_APP_BAR",
    val body: SectionAppBarContentDto? = null
) : BaseBodyDto

data class SectionAppBarContentDto(
    val title: String? = null,
)

data class SectionListDto(
    override val viewType: String = "VIEW_TYPE_LIST",
    val body: SectionListContentDto? = null
) : BaseBodyDto

data class SectionListContentDto(
    val design: DesignDto? = null,
    val body: List<ListBodyDto>? = null
)