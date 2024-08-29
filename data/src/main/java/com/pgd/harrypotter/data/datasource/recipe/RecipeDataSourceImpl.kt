package com.pgd.harrypotter.data.datasource.recipe

import com.pgd.harrypotter.data.entity.IngredientEntity
import com.pgd.harrypotter.data.entity.RecipeEntity
import com.pgd.harrypotter.data.entity.mapper.RecipeEntityMapper
import com.pgd.harrypotter.domain.R
import com.pgd.harrypotter.domain.model.Recipe
import com.pgd.harrypotter.domain.model.resource.ResultState
import javax.inject.Inject

class RecipeDataSourceImpl @Inject constructor(
    // inject your api service here
) : RecipeDataSource {
    override suspend fun getRecipe(): ResultState<Recipe> {

        val strawberryCake = RecipeEntity(
            title = "Strawberry Cake",
            category = "Desserts",
            cookingTime = "50 min",
            energy = "620 kcal",
            rating = "4,9",
            description = "This dessert is very tasty and not difficult to prepare. Also, you can replace strawberries with any other berry you like.",
            reviews = "84 photos     430 comments",
            ingredients = listOf(
                IngredientEntity(R.drawable.flour, "Flour", "450 g"),
                IngredientEntity(R.drawable.eggs, "Eggs", "4"),
                IngredientEntity(R.drawable.juice, "Lemon juice", "150 g"),
                IngredientEntity(R.drawable.strawberry, "Strawberry", "200 g"),
                IngredientEntity(R.drawable.suggar, "Sugar", "1 cup"),
                IngredientEntity(R.drawable.mind, "Mind", "20 g"),
                IngredientEntity(R.drawable.vanilla, "Vanilla", "1/2 teaspoon"),
            )
        )
        return ResultState.Success(RecipeEntityMapper.map(strawberryCake))
    }
}
