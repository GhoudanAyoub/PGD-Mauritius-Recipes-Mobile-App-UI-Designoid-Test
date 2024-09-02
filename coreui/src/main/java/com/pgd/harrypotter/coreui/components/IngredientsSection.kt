package com.pgd.harrypotter.coreui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.pgd.harrypotter.domain.R
import com.pgd.harrypotter.domain.model.Ingredient
import com.pgd.harrypotter.domain.model.Recipe


@Composable
fun IngredientsSection(recipe: Recipe) {
    Column(
        modifier = Modifier
            .heightIn(min = 200.dp, max = 500.dp)
            .padding(8.dp)
            .background(Color.White),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.Top
    ) {
        LazyVerticalGrid(columns = GridCells.Fixed(3)) {
            items(recipe.ingredients.count()) { recipeItemIndex ->
                val ingredient = recipe.ingredients[recipeItemIndex]
                ingredient?.let { current ->
                    IngredientsItem(
                        ingredient = current
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun PreviewIngredientsSection() {
    IngredientsSection(
        recipe = Recipe(
            title = "Strawberry cake",
            cookingTime = "50 min",
            energy = "620 kcal",
            rating = "4.9",
            description = "This dessert is very tasty and not difficult to prepare. Also, you can replace strawberries with any other berry you like.",
            ingredients = listOf(
                Ingredient(R.drawable.flour, "Flour", "450 g"),
                Ingredient(R.drawable.eggs, "Eggs", "4"),
                Ingredient(R.drawable.juice, "Lemon juice", "150 g"),
                Ingredient(R.drawable.strawberry, "Strawberry", "200 g"),
                Ingredient(R.drawable.suggar, "Sugar", "1 cup"),
                Ingredient(R.drawable.mind, "Mind", "20 g"),
                Ingredient(R.drawable.vanilla, "Vanilla", "1/2 teaspoon"),
            ),
            category = "Dessert",
            reviews = "",
            servings = 4
        )
    )
}
