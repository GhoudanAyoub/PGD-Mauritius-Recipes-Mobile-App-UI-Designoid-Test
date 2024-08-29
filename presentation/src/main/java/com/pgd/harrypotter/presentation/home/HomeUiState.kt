package com.pgd.harrypotter.presentation.home

import com.pgd.harrypotter.domain.model.Recipe

sealed class HomeUiState {
    data object Loading : HomeUiState()
    data object Idle : HomeUiState()
    data class Success(val data: Recipe) : HomeUiState()
    data class Exception(val code: Int, val exception: Throwable) : HomeUiState()
}
