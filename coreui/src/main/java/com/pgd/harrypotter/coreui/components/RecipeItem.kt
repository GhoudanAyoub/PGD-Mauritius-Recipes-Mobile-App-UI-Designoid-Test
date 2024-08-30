package com.pgd.harrypotter.coreui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.pgd.harrypotter.coreui.R
import com.pgd.harrypotter.coreui.theme.HarryPotterTheme
import com.pgd.harrypotter.domain.model.Recipe


@Composable
fun RecipeItem(
    recipe: Recipe,
) {
    Surface(color = MaterialTheme.colorScheme.background) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Text(
                recipe.title,
                fontWeight = FontWeight.Bold,
                fontSize = 28.sp,
                fontFamily = MaterialTheme.typography.labelLarge.fontFamily
            )
            Spacer(modifier = Modifier.height(8.dp))
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(
                    modifier = Modifier
                        .size(width = 80.dp, height = 60.dp),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_clock),
                        contentDescription = "Time",
                        modifier = Modifier.size(24.dp)
                    )
                    Text(
                        recipe.cookingTime,
                        modifier = Modifier.padding(start = 8.dp),
                        fontWeight = FontWeight.Bold,
                        fontFamily = MaterialTheme.typography.labelSmall.fontFamily
                    )
                }
                Column(
                    modifier = Modifier
                        .size(width = 80.dp, height = 60.dp),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_flame),
                        contentDescription = "Calories",
                        modifier = Modifier.size(24.dp)
                    )
                    Text(
                        recipe.energy,
                        modifier = Modifier.padding(start = 8.dp),
                        fontWeight = FontWeight.Bold,
                        fontFamily = MaterialTheme.typography.labelSmall.fontFamily
                    )
                }
                Column(
                    modifier = Modifier
                        .size(width = 80.dp, height = 60.dp),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_star),
                        contentDescription = "Rating",
                        modifier = Modifier.size(24.dp)
                    )
                    Text(
                        recipe.rating,
                        modifier = Modifier.padding(start = 8.dp),
                        fontWeight = FontWeight.Bold,
                        fontFamily = MaterialTheme.typography.labelSmall.fontFamily
                    )
                }
            }

            Spacer(modifier = Modifier.height(16.dp))
            Text(
                recipe.description,
                fontSize = 16.sp,
                color = Color.Black,
                fontFamily = MaterialTheme.typography.labelSmall.fontFamily
            )
        }
    }
}


@Preview
@Composable
fun RecipeItemPreview() {
    HarryPotterTheme {
        RecipeItem(
            recipe = Recipe(
                title = "Strawberry cake",
                cookingTime = "50 min",
                energy = "620 kcal",
                rating = "4.9",
                description = "This dessert is very tasty and not difficult to prepare. Also, you can replace strawberries with any other berry you like.",
                ingredients = emptyList(),
                category = "Dessert",
                reviews = ""
            )
        )
    }
}
