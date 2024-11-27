package com.example.recipeapp_android.presentation.screens.home.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import com.example.recipeapp_android.presentation.viewmodel.HomeUiState
import com.example.recipeapp_android.presentation.viewmodel.RecipeViewModel
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.SwipeRefreshIndicator
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState

@Composable
fun SucessScreen(
    recipeViewModel: RecipeViewModel,
    homeUiState: HomeUiState,
    navController: NavHostController
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    colorStops = arrayOf(
                        0.19f to Color(0xFF761C1C),
                        0.20f to Color(0xFF3E0000)
                    )
                )
            )
    ) {

        HeaderHome()

        Column {
            var isRefreshing by remember { mutableStateOf(false) }
            var swipeRefreshState = rememberSwipeRefreshState(isRefreshing = isRefreshing)
            SwipeRefresh(
                state = swipeRefreshState,
                onRefresh = {
                    isRefreshing = true
                    recipeViewModel.fetchRecipesByCountry()

                },
                indicator = { state, trigger ->
                    SwipeRefreshIndicator(
                        state = state,
                        refreshTriggerDistance = trigger,
                        scale = true,
                        backgroundColor = Color(0xFF761C1C),
                        contentColor = Color.White
                    )
                }
            ) {
                CountryRecipeList(homeUiState, recipeViewModel, navController)
            }
        }
    }
}