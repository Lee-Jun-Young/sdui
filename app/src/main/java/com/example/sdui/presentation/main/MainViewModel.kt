package com.example.sdui.presentation.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sdui.domain.ItemRepository
import com.example.sdui.data.dto.SectionItemDto
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: ItemRepository
) : ViewModel() {

    private val _response = MutableLiveData<List<SectionItemDto>>()
    val response: LiveData<List<SectionItemDto>> = _response

    fun getItemList() {
        viewModelScope.launch {
            val aaa = repository.getItemList()
            aaa.forEach {
                Timber.d(it.body.toString())
            }
        }
    }

}