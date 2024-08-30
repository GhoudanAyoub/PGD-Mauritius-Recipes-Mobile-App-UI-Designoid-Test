package com.pgd.harrypotter.coreui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.pgd.harrypotter.domain.R
import com.pgd.harrypotter.domain.model.Ingredient

@Composable
fun IngredientsItem(
    ingredient: Ingredient,
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Card(
            modifier = Modifier
                .size(100.dp)
                .clip(RoundedCornerShape(30.dp)),
            shape = MaterialTheme.shapes.medium,
            elevation = CardDefaults.cardElevation(
                defaultElevation = 0.dp
            ),
            colors = CardDefaults.cardColors(
                containerColor = Color.LightGray
            ),
            onClick = {}
        ) {
            Image(
                painter = painterResource(id = ingredient.image),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxSize(),
                contentScale = ContentScale.Crop
            )

        }
        Column(
            modifier = Modifier
                .size(100.dp, 70.dp),
            horizontalAlignment = Alignment.Start
        ) {
            Text(
                modifier = Modifier.padding(top = 8.dp),
                text = ingredient.title,
                fontSize = 16.sp,
                color = Color.Black
            )
            Text(
                modifier = Modifier.padding(top = 8.dp, bottom = 8.dp),
                text = ingredient.subtitle,
                fontSize = 16.sp,
                color = Color.Gray
            )
        }
    }
}

@Preview
@Composable
fun PreviewIngredientsItem() {
    IngredientsItem(
        ingredient = Ingredient(
            image = R.drawable.flour,
            title = "White bread",
            subtitle = "200 g"
        )
    )
}
