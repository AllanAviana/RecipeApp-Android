package com.example.recipeapp_android.presentation.screens.home.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import com.example.recipeapp_android.R

@Composable
fun HeaderHome(){
    Box(){
        Image(
            painter = painterResource(id = R.drawable.homeimage),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth(),
            contentScale = ContentScale.Crop
        )

        Image(
            painter = painterResource(id = R.drawable.foodapplogo),
            contentDescription = null,
            modifier = Modifier
                .zIndex(1f)
                .size(160.dp)
                .align(Alignment.Center)
                .offset(x =8.dp)
        )

        Text(
            "Get ready to know several kinds of recipes",
            fontSize = 15.sp,
            color = Color.White,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .width(243.dp)
                .align(Alignment.BottomCenter)
                .padding(bottom = 40.dp)
            )
    }
}