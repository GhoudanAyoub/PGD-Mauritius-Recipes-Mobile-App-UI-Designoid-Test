package com.pgd.harrypotter.presentation.home

import HomeBody
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection
import androidx.compose.ui.input.nestedscroll.NestedScrollSource
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.pgd.harrypotter.coreui.components.AppLoader
import com.pgd.harrypotter.coreui.components.ScrollableTopAppBarWithImage


@Composable
fun HomeScreen(
    homeViewModel: HomeViewModel = hiltViewModel(),
) {
    val state by homeViewModel.recipeState.collectAsStateWithLifecycle()

    val toolbarHeight = 250.dp
    val maxUpPx = with(LocalDensity.current) {
        toolbarHeight.roundToPx().toFloat() - 56.dp.roundToPx().toFloat()
    }
    val minUpPx = 0f
    val toolbarOffsetHeightPx = remember { mutableStateOf(0f) }
    val nestedScrollConnection = remember {
        object : NestedScrollConnection {
            override fun onPreScroll(available: Offset, source: NestedScrollSource): Offset {
                val delta = available.y
                val newOffset = toolbarOffsetHeightPx.value + delta
                toolbarOffsetHeightPx.value = newOffset.coerceIn(-maxUpPx, minUpPx)
                return Offset.Zero
            }
        }
    }

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color.White
    ) {
        Box(
            Modifier
                .fillMaxSize()
                .nestedScroll(nestedScrollConnection)
        ) {

            when (state) {
                is HomeUiState.Loading -> {
                    AppLoader()
                }

                is HomeUiState.Success -> {
                    HomeBody(
                        (state as HomeUiState.Success).data,
                        scrollState = rememberScrollState(),
                        toolbarOffsetHeightPx = toolbarOffsetHeightPx.value.dp
                    )
                    ScrollableTopAppBarWithImage(
                        recipe =
                        when (state) {
                            is HomeUiState.Success -> (state as HomeUiState.Success).data
                            else -> null
                        },
                        scrollableAppBarHeight = toolbarHeight,
                        toolbarOffsetHeightPx = toolbarOffsetHeightPx,
                        onFavoriteClickedClicked = { },
                        onBackButtonClickedClicked = {}
                    )
                }

                is HomeUiState.Exception -> {
                    Text(
                        text = "Exception",
                    )
                }

                else -> {
                    AppLoader()
                }
            }
        }
    }
}

@Preview
@Composable
fun HomeScreenPreview() {
    HomeScreen()
}
