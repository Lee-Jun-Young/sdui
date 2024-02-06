package com.example.sdui.data.datasource

import com.example.sdui.data.TestService
import com.example.sdui.data.dto.ResponseDataDto
import timber.log.Timber
import javax.inject.Inject

interface ItemDataSource {
    suspend fun getItemList(): ResponseDataDto
}

class ItemDataSourceImpl @Inject constructor(private val service: TestService) :
    ItemDataSource {
    override suspend fun getItemList(): ResponseDataDto {
        val result = service.getItemList()

        return if (result.isSuccessful) {
            Timber.d(result.body().toString())
            result.body()!!
        } else {
            Timber.d(result.errorBody().toString())
            ResponseDataDto(null, null)
        }
    }
}