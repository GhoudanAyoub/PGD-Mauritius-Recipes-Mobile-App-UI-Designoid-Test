package com.pgd.harrypotter.domain.model

import androidx.annotation.DrawableRes

data class Ingredient(
    @DrawableRes val image: Int,
    val title: String,
    val subtitle: String,
)
