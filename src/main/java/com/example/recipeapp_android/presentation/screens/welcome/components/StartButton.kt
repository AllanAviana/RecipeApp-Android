package com.example.recipeapp_android.presentation.screens.welcome.components

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import androidx.navigation.NavHostController

@Composable
fun StartButton(modifier: Modifier = Modifier, navController: NavHostController) {
    Button(
        onClick = {
            navController.navigate("home_screen")
        },
        modifier = modifier
            .padding(top = 260.dp)
            .zIndex(1f)
            .width(320.dp)
            .height(55.dp),
        colors = ButtonDefaults.buttonColors(Color(0xFF761C1C))
    ) {
        Text("Start", fontSize = 20.sp)
    }
}