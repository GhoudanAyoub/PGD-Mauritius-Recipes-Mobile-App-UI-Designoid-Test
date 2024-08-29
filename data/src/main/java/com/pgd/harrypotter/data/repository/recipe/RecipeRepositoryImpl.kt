package com.pgd.harrypotter.data.repository.recipe

import com.pgd.harrypotter.data.datasource.recipe.RecipeDataSource
import com.pgd.harrypotter.domain.model.Recipe
import com.pgd.harrypotter.domain.model.resource.ResultState
import com.pgd.harrypotter.domain.repository.RecipeRepository
import javax.inject.Inject

class RecipeRepositoryImpl @Inject constructor(
    private val dataSource: RecipeDataSource,
) : RecipeRepository {
    override suspend fun getRecipe(): ResultState<Recipe> {
        return dataSource.getRecipe()
    }
}
