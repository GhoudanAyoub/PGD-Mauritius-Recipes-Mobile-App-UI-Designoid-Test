package com.pgd.harrypotter.domain.usecase.recipe

import kotlinx.coroutines.flow.Flow

interface GetRecipeUseCase {
    suspend fun invoke(): Flow<RecipeRequestState>
}
