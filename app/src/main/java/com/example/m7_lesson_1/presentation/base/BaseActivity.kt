package com.example.m7_lesson_1.presentation.base

import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.example.m7_lesson_1.presentation.utils.UIState
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

abstract class BaseActivity: AppCompatActivity() {

    protected fun <T> StateFlow<UIState<T>>.collectInfo(
        loadingState: (UIState<T>) -> Unit,
        emptyState: (message: String) -> Unit,
        errorState: (message: String) -> Unit,
        successState: (data: T) -> Unit
    ) {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                this@collectInfo.collect {Abc ->
                    when (Abc) {
                        is UIState.Loading -> {
                            loadingState.invoke(UIState.Loading())
                        }
                        is UIState.Empty -> {
                            emptyState.invoke("Data id empty")
                        }
                        is UIState.Error -> {
                            errorState.invoke(Abc.message)
                        }
                        is UIState.Success -> {
                            successState.invoke(Abc.data)
                        }
                    }
                }
            }
        }
    }
}