package com.example.recipeapp_android.presentation.screens.welcome.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.recipeapp_android.R

@Composable
fun BottomImage(modifier: Modifier = Modifier) {
    Image(
        painter = painterResource(id = R.drawable.bottomimage),
        contentDescription = null,
        modifier = modifier
            .fillMaxWidth()
            .height(380.dp),
        contentScale = ContentScale.Crop
    )
}