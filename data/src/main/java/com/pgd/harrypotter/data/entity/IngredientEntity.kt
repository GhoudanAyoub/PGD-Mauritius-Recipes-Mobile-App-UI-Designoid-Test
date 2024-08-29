package com.pgd.harrypotter.data.entity

import androidx.annotation.DrawableRes

data class IngredientEntity(
    @DrawableRes val image: Int,
    val title: String,
    val subtitle: String,
)
