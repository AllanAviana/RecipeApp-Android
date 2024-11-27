package com.example.recipeapp_android.presentation.screens.details

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import coil.compose.rememberAsyncImagePainter
import com.example.recipeapp_android.R
import com.example.recipeapp_android.presentation.viewmodel.Details
import com.example.recipeapp_android.presentation.viewmodel.DetailsUiState
import com.example.recipeapp_android.presentation.viewmodel.RecipeViewModel

@Composable
fun RecipeDetailsScreen(recipeViewModel: RecipeViewModel) {
    val details by recipeViewModel.details.collectAsState()

    when (details) {
        is DetailsUiState.Success -> {
            val recipeDetails = (details as DetailsUiState.Success<Details>).data
            RecipeDetailsSucessScreen(recipeDetails, recipeDetails)
        }
        is DetailsUiState.Error -> {
            val errorMessage = (details as DetailsUiState.Error).message
            DetailsErrorScreen(errorMessage)
        }
        is DetailsUiState.Loading -> {
            DetailsLoadingScreen()
        }

    }

}

@Composable
fun DetailsLoadingScreen() {
    Column() {

    }
}

@Composable
fun DetailsErrorScreen(errorMessage: String) {

}

@Composable
fun RecipeDetailsSucessScreen(recipeDetails: Details, recipeUiState: Details) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    colorStops = arrayOf(
                        0.58f to Color(0xFF691919),
                        1.0f to Color(0xFF993030)
                    )
                )
            )
    ) {
        item {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(280.dp)
            ) {
                Image(
                    painter = rememberAsyncImagePainter(recipeUiState.image),
                    contentDescription = "Food Image",
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.FillBounds
                )

            }
        }

        item {
            ElevatedCard(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(70.dp)
                    .shadow(10.dp, RoundedCornerShape(bottomStart = 32.dp, bottomEnd = 32.dp))
                    .clip(RoundedCornerShape(bottomStart = 32.dp, bottomEnd = 32.dp)),
                colors = CardDefaults.cardColors(Color(0xFF551414)),
            ) {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ){
                    Text(
                        text = recipeUiState.name,
                        color = Color.White,
                        fontSize = 32.sp,
                        textAlign = TextAlign.Center,
                        lineHeight = 32.sp
                    )
                }
            }
        }

        item {
            Spacer(modifier = Modifier.height(16.dp))
        }

        item {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(55.dp)
                    .padding(horizontal = 8.dp)
            ){
                Image(
                    painter = painterResource(id = R.drawable.img),
                    contentDescription = null,
                    modifier = Modifier
                        .align(Alignment.TopStart)
                        .size(55.dp)
                        .zIndex(1f)
                )

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(40.dp)
                        .align(Alignment.BottomStart)
                        .padding(horizontal = 12.dp)
                        .clip(RoundedCornerShape(32.dp))
                        .background(color = Color(0xFF5B0000)),
                    contentAlignment = Alignment.CenterStart
                ){
                    Text(
                        text = "Ingredientes",
                        fontSize = 18.sp,
                        color = Color(0xFF8B2323),
                        modifier = Modifier.padding(start = 50.dp)
                    )
                }
            }
        }

        item {
            Spacer(modifier = Modifier.height(20.dp))
        }

        item {
            Text(
                text = recipeUiState.instructions ?: "",
                color = Color.White,
                fontSize = 14.sp,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp),
                lineHeight = 18.sp,
                textAlign = TextAlign.Start
            )
        }

        item {   Spacer(modifier = Modifier.height(20.dp))}

        // Ingredients List
        items(
            recipeUiState.ingredients.filter { it!!.isNotEmpty() }
        ) { ingredient ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 8.dp, start = 20.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Canvas(modifier = Modifier.size(8.dp)) {
                    val canvasWidth = size.width
                    val canvasHeight = size.height
                    drawCircle(
                        color = Color(0xFFA52323),
                        radius = minOf(canvasWidth, canvasHeight) / 2,
                        center = Offset(canvasWidth / 2, canvasHeight / 2)
                    )
                }
                Text(
                    text = ingredient!!,
                    color = Color.White,
                    fontSize = 18.sp,
                    modifier = Modifier.padding(start = 10.dp)
                )
            }
        }

        item { Spacer(modifier = Modifier.height(60.dp)) }
    }


}
