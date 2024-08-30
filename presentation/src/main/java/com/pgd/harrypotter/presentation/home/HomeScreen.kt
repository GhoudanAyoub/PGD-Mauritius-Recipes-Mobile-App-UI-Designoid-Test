package com.pgd.harrypotter.presentation.home

import HomeBody
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.pgd.harrypotter.coreui.components.AppLoader
import com.pgd.harrypotter.coreui.components.ScrollableTopAppBarWithImage


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    homeViewModel: HomeViewModel = hiltViewModel(),
) {
    val state by homeViewModel.recipeState.collectAsStateWithLifecycle()
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()

    Scaffold(
        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            ScrollableTopAppBarWithImage(
                recipe =
                when (state) {
                    is HomeUiState.Success -> (state as HomeUiState.Success).data
                    else -> null
                },
                onFavoriteClickedClicked = { },
                onBackButtonClickedClicked = {}
            )
        },
        content = { paddingValues ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
                    .background(MaterialTheme.colorScheme.background)
            ) {
                when (state) {
                    is HomeUiState.Loading -> {
                        AppLoader()
                    }

                    is HomeUiState.Success -> {
                        HomeBody((state as HomeUiState.Success).data)
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
    )
}

@Preview
@Composable
fun HomeScreenPreview() {
    HomeScreen()
}
