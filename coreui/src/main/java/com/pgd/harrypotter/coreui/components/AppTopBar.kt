package com.pgd.harrypotter.coreui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.pgd.harrypotter.coreui.R
import com.pgd.harrypotter.coreui.theme.HarryPotterTheme
import com.pgd.harrypotter.domain.model.Recipe

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScrollableTopAppBarWithImage(
    recipe: Recipe?,
    onFavoriteClickedClicked: (recipe: Recipe?) -> Unit,
    onBackButtonClickedClicked: () -> Unit,
) {
    val scrollState = rememberScrollState()
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()

    Box(modifier = Modifier.fillMaxWidth()) {
        Card(
            shape = MaterialTheme.shapes.medium,
            elevation = CardDefaults.cardElevation(
                defaultElevation = 8.dp
            ),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.surface
            )
        ) {
            Image(
                painter = painterResource(id = com.pgd.harrypotter.domain.R.drawable.strawberry_pie_1),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(250.dp)
                    .alpha(1f - (scrollState.value / 600f).coerceIn(0f, 1f)),
                contentScale = ContentScale.Crop
            )
        }
        // Overlaying Buttons
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            IconButton(
                onClick = { onBackButtonClickedClicked.invoke() },
                modifier = Modifier
                    .size(40.dp)
                    .clip(RoundedCornerShape(16.dp))
                    .background(Color.White.copy(alpha = 0.7f))
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_arrow_back),
                    tint = Color.LightGray,
                    contentDescription = "Back"
                )
            }

            IconButton(
                onClick = { onFavoriteClickedClicked.invoke(recipe) },
                modifier = Modifier
                    .size(40.dp)
                    .clip(RoundedCornerShape(16.dp))
                    .background(Color.White.copy(alpha = 0.7f))
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_favorite),
                    tint = Color.LightGray,
                    contentDescription = "Favorite"
                )
            }
        }

        // TopAppBar over the image
        TopAppBar(
            title = {
                Text(text = "")
            },
            scrollBehavior = scrollBehavior,
            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = Color(0x00FFFFFF)
            )
        )
    }
}

@Preview(apiLevel = 33)
@Composable
fun ScrollableTopAppBarWithImagePreview() {
    HarryPotterTheme {
        ScrollableTopAppBarWithImage(
            recipe = Recipe(
                title = "Strawberry cake",
                cookingTime = "50 min",
                energy = "620 kcal",
                rating = "4.9",
                description = "This dessert is very tasty and not difficult to prepare. Also, you can replace strawberries with any other berry you like.",
                ingredients = emptyList(),
                category = "Dessert",
                reviews = ""
            ),
            onFavoriteClickedClicked = {},
            onBackButtonClickedClicked = {}
        )
    }
}
