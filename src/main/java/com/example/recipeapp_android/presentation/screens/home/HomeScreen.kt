package com.example.recipeapp_android.presentation.screens.home

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.example.recipeapp_android.presentation.screens.home.components.ErrorScreen
import com.example.recipeapp_android.presentation.screens.home.components.LoadingScreen
import com.example.recipeapp_android.presentation.screens.home.components.SucessScreen
import com.example.recipeapp_android.presentation.viewmodel.HomeUiState
import com.example.recipeapp_android.presentation.viewmodel.RecipeUiState
import com.example.recipeapp_android.presentation.viewmodel.RecipeViewModel

@Composable
fun HomeScreen(recipeViewModel: RecipeViewModel) {
    val recipes by recipeViewModel.recipes.collectAsState()
    when (recipes) {
        is RecipeUiState.Success -> {
            val homeUiState = (recipes as RecipeUiState.Success<HomeUiState>).data
            SucessScreen(recipeViewModel, homeUiState)
        }
        is RecipeUiState.Error -> {
            val errorMessage = (recipes as RecipeUiState.Error).message
            ErrorScreen(errorMessage)
        }
        is RecipeUiState.Loading -> {
            LoadingScreen()
        }
    }
}