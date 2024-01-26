package com.example.sdui.data.datasource

import com.example.sdui.data.dto.SectionItemDto
import com.google.gson.Gson
import javax.inject.Inject

interface ItemDataSource {
    suspend fun getItemList(): List<SectionItemDto>
}

class ItemDataSourceImpl @Inject constructor() :
    ItemDataSource {
    override suspend fun getItemList(): List<SectionItemDto> {
        val list = mutableListOf<SectionItemDto>()

        list.add(getBannerItem())
        list.add(getGridItem())
        list.add(getCardItem())

        return list
    }

    private fun getCardItem(): SectionItemDto {
        val jsonString = """{
             "viewType": "VIEW_TYPE_CARD",
              "header": {
                "header": "Card Type"
              },
              "design": {
                "width": "50",
                "height": "50",
                "top": "8",
                "left": "16",
                "bottom": "8",
                "right": "16"
              },
              "body": [
                {
                  "url": "",
                  "title": "자장면",
                  "price": "9,000",
                  "rate": "4.2"
                },
                {
                  "url": "",
                  "title": "김치찌개",
                  "price": "11,000",
                  "rate": "4.6"
                },
                {
                  "url": "",
                  "title": "우동",
                  "price": "9,000",
                  "rate": "4.7"
                },
                {
                  "url": "",
                  "title": "피자",
                  "price": "32,000",
                  "rate": "4.8"
                },
                {
                  "url": "",
                  "title": "햄버거",
                  "price": "12,000",
                  "rate": "4.4"
                },
                {
                  "url": "",
                  "title": "치킨",
                  "price": "22,000",
                  "rate": "4.9"
                },
                {
                  "url": "",
                  "title": "빵",
                  "price": "14,000",
                  "rate": "4.5"
                }
              ]   
        }"""
        return Gson().fromJson(jsonString, SectionItemDto::class.java)
    }

    private fun getBannerItem(): SectionItemDto {
        val jsonString = """{
              "viewType": "VIEW_TYPE_BANNER",
              "header": {
                "header": "Banner Type"
              },
              "design": {
                "width": "0",
                "height": "0",
                "top": "4",
                "left": "4",
                "bottom": "4",
                "right": "4"
              },
              "body": [
                {
                  "url": "ic_bg_1",
                  "title": "",
                  "description": ""
                },
                {
                  "url": "ic_bg_2",
                  "title": "",
                  "description": ""
                },
                {
                  "url": "ic_bg_1",
                  "title": "",
                  "description": ""
                },
                {
                  "url": "ic_bg_2",
                  "title": "",
                  "description": ""
                },
                {
                  "url": "ic_bg_1",
                  "title": "",
                  "description": ""
                },
                {
                  "url": "ic_bg_2",
                  "title": "",
                  "description": ""
                }
            ]
        }"""
        return Gson().fromJson(jsonString, SectionItemDto::class.java)
    }

    private fun getGridItem(): SectionItemDto {
        val jsonString = """{
            "viewType": "VIEW_TYPE_GRID",
            "header": {
                "header": "Grid Type"
            },
            "design": {
                "width": "50",
                "height": "50",
                "top": "8",
                "left": "8",
                "bottom": "8",
                "right": "8"
            },
            "grid_info": {
                "row": "2",
                "col": "3",
                "orientation": "vertical"
            },
            "body": [
                {
                  "url": "",
                  "title": "중식"
                },
                {
                  "url": "",
                  "title": "양식"
                },
                {
                  "url": "",
                  "title": "한식"
                },
                {
                  "url": "",
                  "title": "일식"
                },
                {
                  "url": "",
                  "title": "패스트푸드"
                },
                {
                  "url": "",
                  "title": "베이커리"
                }
            ]
        }"""
        return Gson().fromJson(jsonString, SectionItemDto::class.java)
    }
}