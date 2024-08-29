package com.pgd.harrypotter.domain.usecase.recipe

import com.pgd.harrypotter.domain.model.Recipe

sealed class RecipeRequestState {
    data object Loading : RecipeRequestState()
    data class Success(val data: Recipe) : RecipeRequestState()
    data class Exception(val code: Int = -1, val exception: Throwable) :
        RecipeRequestState()
}
