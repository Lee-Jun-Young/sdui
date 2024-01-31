package com.example.sdui.data.datasource

import com.example.sdui.data.TestService
import com.example.sdui.data.dto.SectionAppBarDto
import com.example.sdui.data.dto.SectionBannerDto
import com.example.sdui.data.dto.SectionCardDto
import com.example.sdui.data.dto.SectionListDto
import com.example.sdui.data.dto.TypeDataDto
import com.google.gson.Gson
import timber.log.Timber
import javax.inject.Inject

interface ItemDataSource {
    suspend fun getItemList(): List<TypeDataDto>
}

class ItemDataSourceImpl @Inject constructor(private val service: TestService) :
    ItemDataSource {
    override suspend fun getItemList(): List<TypeDataDto> {
        val result = service.getItemList()

        val list: MutableList<TypeDataDto> = mutableListOf()

        if (result.isSuccessful) {
            result.body()?.sections?.forEach {
                when (it.viewType) {
                    "VIEW_TYPE_CARD" -> {
                        val temp = Gson().toJson(it.body)
                        val temp2 = Gson().fromJson(temp, SectionCardDto::class.java)

                        list.add(TypeDataDto("VIEW_TYPE_CARD", temp2))
                    }

                    "VIEW_TYPE_BANNER" -> {
                        val temp = Gson().toJson(it.body)
                        val temp2 = Gson().fromJson(temp, SectionBannerDto::class.java)
                        list.add(TypeDataDto("VIEW_TYPE_BANNER", temp2))
                    }

                    "VIEW_TYPE_APP_BAR" -> {
                        val temp = Gson().toJson(it.body)
                        val temp2 = Gson().fromJson(temp, SectionAppBarDto::class.java)
                        list.add(TypeDataDto("VIEW_TYPE_APP_BAR", temp2))
                    }

                    "VIEW_TYPE_LIST" -> {
                        val temp = Gson().toJson(it.body)
                        val temp2 = Gson().fromJson(temp, SectionListDto::class.java)
                        list.add(TypeDataDto("VIEW_TYPE_LIST", temp2))
                    }
                }
            }
        } else {
            Timber.d(result.errorBody().toString())
        }

        return list
    }
}