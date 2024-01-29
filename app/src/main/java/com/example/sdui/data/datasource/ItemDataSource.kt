package com.example.sdui.data.datasource

import android.util.Log
import com.example.sdui.data.TestService
import com.example.sdui.data.dto.BaseDto
import com.example.sdui.data.dto.SectionItemDto
import com.example.sdui.data.dto.SectionsDto
import com.google.gson.Gson
import javax.inject.Inject

interface ItemDataSource {
    suspend fun getItemList(): SectionsDto
}

class ItemDataSourceImpl @Inject constructor(private val service: TestService) :
    ItemDataSource {
    override suspend fun getItemList(): SectionsDto {
        val response = service.getItemList()
        if(response.isSuccessful) {
            val body = response.body()
            val gson = Gson()
            val json = gson.toJson(body)
            Log.d("TAG", "getItemList: $json")
        }else{
            Log.d("TAG", "getItemList: ${response.errorBody()}")
        }
        val list = SectionsDto(null, null, null, null)
        return list
    }
}