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
                "top": "2",
                "left": "4",
                "bottom": "2",
                "right": "2"
              },
              "body": [
                {
                  "url": "",
                  "title": "한국",
                  "price": "10,000",
                  "rate": "4.6"
                },
                {
                  "url": "",
                  "title": "미국",
                  "price": "10,000",
                  "rate": "4.6"
                },
                {
                  "url": "",
                  "title": "영국",
                  "price": "10,000",
                  "rate": "4.6"
                },
                {
                  "url": "",
                  "title": "중국",
                  "price": "10,000",
                  "rate": "4.6"
                },
                {
                  "url": "",
                  "title": "독일",
                  "price": "10,000",
                  "rate": "4.6"
                },
                {
                  "url": "",
                  "title": "일본",
                  "price": "10,000",
                  "rate": "4.6"
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
        "top": "2",
        "left": "4",
        "bottom": "2",
        "right": "2"
      },
      "body": [
        {
          "url": "",
          "title": "",
          "description": ""
        },
        {
          "url": "",
          "title": "",
          "description": ""
        },
        {
          "url": "",
          "title": "",
          "description": ""
        },
        {
          "url": "",
          "title": "",
          "description": ""
        },
        {
          "url": "",
          "title": "",
          "description": ""
        },
        {
          "url": "",
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
                "top": "2",
                "left": "4",
                "bottom": "2",
                "right": "2"
            },
            "grid_info": {
                "row": "4",
                "col": "3",
                "orientation": ""
            },
            "body": [
                {
                  "url": "",
                  "title": "한국"
                },
                {
                  "url": "",
                  "title": "미국"
                },
                {
                  "url": "",
                  "title": "영국"
                },
                {
                  "url": "",
                  "title": "중국"
                },
                {
                  "url": "",
                  "title": "독일"
                },
                {
                  "url": "",
                  "title": "일본"
                }
            ]
        }"""
        return Gson().fromJson(jsonString, SectionItemDto::class.java)
    }
}