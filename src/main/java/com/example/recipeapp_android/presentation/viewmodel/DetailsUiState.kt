package com.example.recipeapp_android.presentation.viewmodel

sealed class DetailsUiState<out T>{
    data class Success<out T>(val data: T) : DetailsUiState<T>()
    data class Error(val message: String) : DetailsUiState<Nothing>()
    data object Loading : DetailsUiState<Nothing>()
}

data class Details(
    val image: String = "",
    val name: String = "",
    val ingredients: List<String?> = emptyList(),
    val instructions: String = ""
)