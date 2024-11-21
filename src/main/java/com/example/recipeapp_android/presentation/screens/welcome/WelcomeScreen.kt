package com.example.recipeapp_android.presentation.screens.welcome

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import com.example.recipeapp_android.presentation.screens.welcome.components.BottomImage
import com.example.recipeapp_android.presentation.screens.welcome.components.CentralImage
import com.example.recipeapp_android.presentation.screens.welcome.components.FeatureRow
import com.example.recipeapp_android.presentation.screens.welcome.components.StartButton
import com.example.recipeapp_android.presentation.screens.welcome.components.WelcomeText
import com.example.recipeapp_android.presentation.viewmodel.RecipeViewModel

@Composable
fun WelcomeScreen(recipeViewModel: RecipeViewModel) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    colorStops = arrayOf(
                        0.42f to Color(0xFF761C1C),
                        0.77f to Color(0xFF000000)
                    )
                )
            )
    ) {

        WelcomeText(modifier = Modifier.align(Alignment.TopCenter))

        CentralImage(modifier = Modifier.align(Alignment.Center))

        StartButton(modifier = Modifier.align(Alignment.Center))

        FeatureRow(modifier = Modifier.align(Alignment.BottomCenter))

        BottomImage(modifier = Modifier.align(Alignment.BottomCenter))
    }
}
