package com.example.sdui.data.datasource

import android.util.Log
import com.example.sdui.data.TestService
import com.example.sdui.data.dto.ResponseDataDto
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
        val aaa = service.getItemList()

        val list: MutableList<TypeDataDto> = mutableListOf()

        if (aaa.isSuccessful) {
            aaa.body()?.sections?.forEach {
                when (it.viewType) {
                    "VIEW_TYPE_CARD" -> {
                        val temp = Gson().toJson(it.body)
                        val temp2 = Gson().fromJson(temp, SectionCardDto::class.java)

                        list.add(TypeDataDto("VIEW_TYPE_CARD", temp2))
                    }

                    "VIEW_TYPE_BANNER" -> {
                        Timber.d(it.body.toString())
                        list.add(TypeDataDto("VIEW_TYPE_BANNER", it.body))
                    }

                    "VIEW_TYPE_APP_BAR" -> {
                        val temp = Gson().toJson(it.body)
                        val temp2 = Gson().fromJson(temp, SectionAppBarDto::class.java)
                        list.add(TypeDataDto("VIEW_TYPE_APP_BAR", temp2))
                    }

                    "VIEW_TYPE_LIST" -> {
                        // list.add(TypeDataDto("VIEW_TYPE_LIST", aaa))
                    }
                }
            }
        } else {
            Timber.d("fail")
        }

        return list
    }
}