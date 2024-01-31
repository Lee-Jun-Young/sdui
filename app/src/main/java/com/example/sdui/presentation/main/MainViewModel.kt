package com.example.sdui.presentation.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sdui.data.dto.SectionAppBarDto
import com.example.sdui.data.dto.SectionBannerDto
import com.example.sdui.data.dto.SectionCardDto
import com.example.sdui.data.dto.SectionListDto
import com.example.sdui.data.dto.TypeDataDto
import com.example.sdui.domain.ItemRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: ItemRepository
) : ViewModel() {

    private val _response = MutableLiveData<List<TypeDataDto>>()
    val response: LiveData<List<TypeDataDto>> = _response

    fun getItemList() {
        viewModelScope.launch {
            val result = repository.getItemList()
            result.forEach {
                when (it.viewType) {
                    "VIEW_TYPE_CARD" -> {
                        val body = it.body as SectionCardDto
                        addList("VIEW_TYPE_CARD", body)
                    }

                    "VIEW_TYPE_BANNER" -> {
                        val body = it.body as SectionBannerDto
                        addList("VIEW_TYPE_BANNER", body)
                    }

                    "VIEW_TYPE_APP_BAR" -> {
                        val body = it.body as SectionAppBarDto
                        addList("VIEW_TYPE_APP_BAR", body)
                    }

                    "VIEW_TYPE_LIST" -> {
                        val body = it.body as SectionListDto
                        addList("VIEW_TYPE_LIST", body)
                    }
                }
            }
        }
    }

    private fun addList(viewType: String, data: Any) {
        val newData = TypeDataDto(viewType, data)
        if (_response.value != null) {
            _response.value = _response.value!! + newData
        } else {
            _response.value = listOf(newData)
        }
    }

}