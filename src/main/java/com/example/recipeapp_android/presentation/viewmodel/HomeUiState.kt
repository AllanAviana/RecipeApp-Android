package com.example.recipeapp_android.presentation.viewmodel

import com.example.recipeapp_android.data.remote.model.Meal

sealed class  RecipeUiState<out T> {
    data class Success<out T>(val data: T) : RecipeUiState<T>()
    data class Error(val message: String) : RecipeUiState<Nothing>()
    data object Loading : RecipeUiState<Nothing>()
}

data class HomeUiState(
    val americans: List<Meal> = emptyList(),
    val italian: List<Meal> = emptyList(),
    val mexican: List<Meal> = emptyList(),
    val japanese: List<Meal> = emptyList(),
    val chinese: List<Meal> = emptyList()
)
