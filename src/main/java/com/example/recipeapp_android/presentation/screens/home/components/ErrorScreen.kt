package com.example.recipeapp_android.presentation.screens.home.components

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun ErrorScreen(errorMessage: String) {
    Text(text = "Error: $errorMessage")
}