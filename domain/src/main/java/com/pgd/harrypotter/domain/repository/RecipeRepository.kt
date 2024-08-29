package com.pgd.harrypotter.domain.repository

import com.pgd.harrypotter.domain.model.Recipe
import com.pgd.harrypotter.domain.model.resource.ResultState

interface RecipeRepository {
    suspend fun getRecipe(): ResultState<Recipe>
}
