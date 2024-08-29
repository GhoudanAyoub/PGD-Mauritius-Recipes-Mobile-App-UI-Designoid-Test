package com.pgd.harrypotter.data.entity.mapper

import com.pgd.harrypotter.data.entity.IngredientEntity
import com.pgd.harrypotter.domain.model.Ingredient


object IngredientEntityMapper : Mapper<List<IngredientEntity>, List<Ingredient>> {
    override fun map(data: List<IngredientEntity>): List<Ingredient> = data.map {
        Ingredient(
            image = it.image,
            title = it.title,
            subtitle = it.subtitle
        )
    }
}
