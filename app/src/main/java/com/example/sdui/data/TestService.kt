package com.example.sdui.data

import com.example.sdui.data.dto.BaseDto
import com.example.sdui.data.dto.SectionsDto
import retrofit2.Response
import retrofit2.http.GET

interface TestService {

    @GET("list")
    suspend fun getItemList(): Response<BaseDto>
}