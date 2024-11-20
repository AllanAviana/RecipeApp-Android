package com.example.recipeapp_android.presentation.screens.welcome.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import com.example.recipeapp_android.R

@Composable
fun FeatureRow(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .zIndex(1f)
            .padding(bottom = 70.dp),
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        FeatureItem(
            imageRes = R.drawable.spondandfork,
            text = "Recipes"
        )
        FeatureItem(
            imageRes = R.drawable.welcomehearth,
            text = "Save your favorite recipes",
            textWidth = 160.dp
        )
    }
}