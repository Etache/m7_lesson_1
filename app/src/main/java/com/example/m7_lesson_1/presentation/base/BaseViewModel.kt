package com.example.m7_lesson_1.presentation.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.m7_lesson_1.domain.utils.Resource
import com.example.m7_lesson_1.presentation.utils.UIState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

abstract class BaseViewModel : ViewModel() {

    protected fun <T> Flow<Resource<T>>.collectData(
        _state: MutableStateFlow<UIState<T>>
    ) {
        viewModelScope.launch {
            this@collectData.collect { abc ->
                when (abc) {
                    is Resource.Error -> {
                        _state.value = UIState.Error(abc.message ?: "Some error")
                    }
                    is Resource.Loading -> {
                        _state.value = UIState.Loading()
                    }
                    is Resource.Success -> {
                        if (abc.data != null) {
                            _state.value = UIState.Success(abc.data)
                        } else {
                            println("You don't have abc")
                        }
                    }
                }
            }
        }
    }
}