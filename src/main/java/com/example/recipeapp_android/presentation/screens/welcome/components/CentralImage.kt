package com.example.recipeapp_android.presentation.screens.welcome.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.recipeapp_android.R

@Composable
fun CentralImage(modifier: Modifier = Modifier) {
    Image(
        painter = painterResource(id = R.drawable.welcomeimage),
        contentDescription = null,
        modifier = modifier
            .width(380.dp)
            .height(340.dp)
            .offset(y = -40.dp),
    )
}