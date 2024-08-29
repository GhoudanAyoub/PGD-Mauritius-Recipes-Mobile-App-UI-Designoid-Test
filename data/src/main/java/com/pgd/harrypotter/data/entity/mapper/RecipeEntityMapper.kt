package com.pgd.harrypotter.data.entity.mapper

import com.pgd.harrypotter.data.entity.RecipeEntity
import com.pgd.harrypotter.domain.model.Recipe


object RecipeEntityMapper : Mapper<RecipeEntity, Recipe> {
    override fun map(data: RecipeEntity): Recipe = Recipe(
        title = data.title,
        category = data.category,
        cookingTime = data.cookingTime,
        energy = data.energy,
        rating = data.rating,
        description = data.description,
        reviews = data.reviews,
        ingredients = IngredientEntityMapper.map(data.ingredients)
    )
}
