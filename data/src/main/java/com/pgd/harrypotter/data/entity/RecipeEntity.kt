package com.pgd.harrypotter.data.entity


data class RecipeEntity(
    val title: String,
    val category: String,
    val cookingTime: String,
    val energy: String,
    val rating: String,
    val description: String,
    val reviews: String,
    val ingredients: List<IngredientEntity>,
)
