package com.pgd.harrypotter.presentation.home.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.pgd.harrypotter.presentation.home.HomeScreen

const val HOME_ROUTE = "home"
fun NavGraphBuilder.homeScreen() {
    composable(HOME_ROUTE) {
        HomeScreen()
    }
}
