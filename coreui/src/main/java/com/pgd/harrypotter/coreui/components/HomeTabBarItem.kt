package com.pgd.harrypotter.coreui.components

import androidx.compose.animation.core.animateDp
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.TabPosition
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import com.pgd.harrypotter.coreui.theme.HarryPotterTheme
import com.pgd.harrypotter.domain.R
import com.pgd.harrypotter.domain.model.Ingredient
import com.pgd.harrypotter.domain.model.Recipe
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeTabBarItem(
    recipe: Recipe,
) {
    val tabWidth = (LocalConfiguration.current.screenWidthDp / 3).dp - 10.dp
    val coroutineScope = rememberCoroutineScope()
    val pagerState =
        rememberPagerState(pageCount = { 3 })
    val pages = listOf("Ingredients", "Tools", "Steps")

    val indicator = @Composable { tabPositions: List<TabPosition> ->
        CustomIndicator(tabPositions, pagerState)
    }
    Column {

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(50))
                .padding(12.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(
                        color = Color.White
                    )
                    .clip(RoundedCornerShape(50)),
            ) {
                ScrollableTabRow(
                    modifier = Modifier
                        .height(45.dp)
                        .fillMaxWidth()
                        .background(
                            color = Color(0xBFF7F7F7),
                        )
                        .clip(RoundedCornerShape(50)),
                    containerColor = Color(0xBFF7F7F7),
                    edgePadding = 0.dp,
                    selectedTabIndex = pagerState.currentPage,
                    indicator = indicator
                ) {
                    pages.forEachIndexed { index, title ->
                        Tab(
                            modifier = Modifier
                                .width(tabWidth)
                                .zIndex(6f),
                            text = {
                                Text(
                                    text = title,
                                    color = Color.LightGray,
                                    fontSize = 16.sp
                                )
                            },
                            selected = pagerState.currentPage == index,
                            onClick = {
                                coroutineScope.launch {
                                    pagerState.animateScrollToPage(index)
                                }
                            },
                        )
                    }
                }
            }
        }

        HorizontalPager(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    color = Color.White
                ),
            state = pagerState,
        ) { page ->
            when (page) {
                0 -> IngredientsSection(recipe = recipe)
                1 -> ToolsSection()
                2 -> StepsSection()
            }
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
private fun CustomIndicator(tabPositions: List<TabPosition>, pagerState: PagerState) {
    val transition = updateTransition(pagerState.currentPage)
    val indicatorStart by transition.animateDp(
        transitionSpec = {
            if (initialState < targetState) {
                spring(dampingRatio = 1f, stiffness = 50f)
            } else {
                spring(dampingRatio = 1f, stiffness = 1000f)
            }
        }, label = ""
    ) {
        tabPositions[it].left
    }

    val indicatorEnd by transition.animateDp(
        transitionSpec = {
            if (initialState < targetState) {
                spring(dampingRatio = 1f, stiffness = 1000f)
            } else {
                spring(dampingRatio = 1f, stiffness = 50f)
            }
        }, label = ""
    ) {
        tabPositions[it].right
    }


    Box(
        Modifier
            .offset(x = indicatorStart)
            .wrapContentSize(align = Alignment.BottomStart)
            .width(indicatorEnd - indicatorStart)
            .padding(2.dp)
            .fillMaxSize()
            .background(
                color = Color(0xFFB21C55),
                shape = RoundedCornerShape(50)
            )
            .zIndex(1f)
    )
}

@Preview
@Composable
fun TabBarItemPreview() {
    HarryPotterTheme {
        HomeTabBarItem(
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
}
