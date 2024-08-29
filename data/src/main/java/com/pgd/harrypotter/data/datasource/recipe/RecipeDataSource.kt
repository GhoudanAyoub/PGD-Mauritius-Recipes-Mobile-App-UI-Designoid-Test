package com.pgd.harrypotter.data.datasource.recipe

import com.pgd.harrypotter.domain.model.Recipe
import com.pgd.harrypotter.domain.model.resource.ResultState

interface RecipeDataSource {
    suspend fun getRecipe(): ResultState<Recipe>
}
