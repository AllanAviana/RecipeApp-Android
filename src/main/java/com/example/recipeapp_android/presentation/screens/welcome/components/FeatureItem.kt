package com.example.recipeapp_android.presentation.screens.welcome.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun FeatureItem(imageRes: Int, text: String, textWidth: Dp = Dp.Unspecified) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Box(
            modifier = Modifier
                .size(99.dp)
                .clip(CircleShape)
                .border(
                    BorderStroke(3.dp, Color(0xFFCBCBCB)),
                    shape = CircleShape
                )
        ) {
            Image(
                painter = painterResource(id = imageRes),
                contentDescription = null,
                modifier = Modifier
                    .align(Alignment.Center)
                    .size(64.dp),
            )
        }
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = text,
            textAlign = if (textWidth != Dp.Unspecified) TextAlign.Center else TextAlign.Start,
            fontSize = 20.sp,
            modifier = if (textWidth != Dp.Unspecified) Modifier.width(textWidth) else Modifier
        )
    }
}