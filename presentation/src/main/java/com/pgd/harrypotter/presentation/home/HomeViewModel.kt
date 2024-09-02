package com.pgd.harrypotter.presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pgd.harrypotter.domain.usecase.recipe.GetRecipeUseCase
import com.pgd.harrypotter.domain.usecase.recipe.RecipeRequestState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlin.time.Duration.Companion.seconds
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getRecipeUseCase: GetRecipeUseCase,
) : ViewModel() {

    private val _RecipeState: MutableStateFlow<HomeUiState> =
        MutableStateFlow(HomeUiState.Idle)
    val recipeState: StateFlow<HomeUiState> = _RecipeState.asStateFlow()

    private val _timerState: MutableStateFlow<Int> =
        MutableStateFlow(0)
    val timerState: StateFlow<Int> = _timerState.asStateFlow()


    init {
        getRecipe()
    }

    private fun getRecipe() {
        viewModelScope.launch {
            getRecipeUseCase.invoke()
                .collect { data ->
                    _RecipeState.value = when (data) {
                        is RecipeRequestState.Loading -> HomeUiState.Loading
                        is RecipeRequestState.Success -> HomeUiState.Success(data.data)
                        is RecipeRequestState.Exception -> HomeUiState.Exception(
                            data.code,
                            data.exception
                        )
                    }
                }
        }
    }

    fun startCooking() {
        viewModelScope.launch {
            while (true) {
                delay(1.seconds)
                _timerState.value = ++_timerState.value
            }
        }
    }
}
