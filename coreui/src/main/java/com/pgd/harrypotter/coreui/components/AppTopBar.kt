package com.pgd.harrypotter.coreui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.pgd.harrypotter.coreui.R
import com.pgd.harrypotter.domain.model.Recipe
import kotlin.math.roundToInt

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScrollableTopAppBarWithImage(
    recipe: Recipe?,
    scrollableAppBarHeight: Dp,
    toolbarOffsetHeightPx: MutableState<Float>,
    onFavoriteClickedClicked: (recipe: Recipe?) -> Unit,
    onBackButtonClickedClicked: () -> Unit,
) {

    val scrollBehavior =
        TopAppBarDefaults.exitUntilCollapsedScrollBehavior(rememberTopAppBarState())


    Box(
        modifier = Modifier
            .heightIn(min = 80.dp, max = scrollableAppBarHeight)
            .offset {
                IntOffset(x = 0, y = toolbarOffsetHeightPx.value.roundToInt()) //设置偏移量
            }
            .fillMaxWidth()
    ) {
        Box(modifier = Modifier
            .fillMaxSize()
            .height(scrollableAppBarHeight)
            .offset {
                IntOffset(x = 0, y = toolbarOffsetHeightPx.value.roundToInt()) //设置偏移量
            }) {
            Card(
                shape = MaterialTheme.shapes.medium,
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 2.dp
                ),
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.surface
                )
            ) {
                Image(
                    painter = painterResource(id = com.pgd.harrypotter.domain.R.drawable.strawberry_pie_1),
                    contentScale = ContentScale.FillBounds,
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(250.dp)
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
                        .background(Color.White)
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_arrow_back),
                        tint = Color.Gray,
                        contentDescription = "Back"
                    )
                }

                IconButton(
                    onClick = { onFavoriteClickedClicked.invoke(recipe) },
                    modifier = Modifier
                        .size(40.dp)
                        .clip(RoundedCornerShape(16.dp))
                        .background(Color.White)
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_favorite),
                        tint = Color.Gray,
                        contentDescription = "Favorite"
                    )
                }
            }


            // the gradient overlay
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .height(scrollableAppBarHeight)
                    .offset {
                        IntOffset(x = 0, y = toolbarOffsetHeightPx.value.roundToInt()) //设置偏移量
                    }
                    .background(
                        Brush.verticalGradient(
                            colors = listOf(Color.Transparent, Color.White.copy(alpha = 0.6f)),
                            startY = 200f
                        )
                    )
            ) {}

            // Category Text above the image
            Text(
                text = recipe?.category ?: "",
                color = Color.Black,
                fontSize = 16.sp,
                modifier = Modifier
                    .align(Alignment.BottomStart)
                    .padding(start = 16.dp, bottom = 8.dp) // Adjust the padding as needed
                    .background(
                        Color(0xBFF7F7F7), // Optional background for the text
                        shape = RoundedCornerShape(10.dp)
                    )
                    .padding(horizontal = 8.dp, vertical = 4.dp)
            )
        }
    }

}
