package com.example.sdui.data.datasource

import android.util.Log
import com.example.sdui.data.TestService
import com.example.sdui.data.dto.SectionBannerDto
import com.google.gson.Gson
import timber.log.Timber
import javax.inject.Inject

interface ItemDataSource {
    suspend fun getItemList(): SectionBannerDto
}

class ItemDataSourceImpl @Inject constructor(private val service: TestService) :
    ItemDataSource {
    override suspend fun getItemList(): SectionBannerDto {
        val aaa = service.getItemList()

        Timber.d(aaa.errorBody().toString())
        Timber.d(aaa.body().toString())
        if (aaa.isSuccessful) {
            Timber.d("getItemList: success}")
            Timber.d("getItemList: ${aaa.body()}")
        } else {
            Timber.d("getItemList: fail")
            Timber.d("qq: ${aaa.errorBody()}")
        }

        return SectionBannerDto(title = null, id = null)
    }
}