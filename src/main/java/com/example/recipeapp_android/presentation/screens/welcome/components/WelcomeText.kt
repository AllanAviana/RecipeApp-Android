package com.example.recipeapp_android.presentation.screens.welcome.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun WelcomeText(modifier: Modifier = Modifier) {
    Text(
        text = "Welcome to FoodApp",
        fontSize = 32.sp,
        color = Color.White,
        modifier = modifier
            .fillMaxWidth(0.5f)
            .padding(top = 120.dp),
        textAlign = TextAlign.Center
    )
}