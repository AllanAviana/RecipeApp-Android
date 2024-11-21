package com.example.recipeapp_android.presentation.screens.home.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.recipeapp_android.presentation.viewmodel.HomeUiState

@Composable
fun CountryRecipeList(homeUiState: HomeUiState) {

    val countries = listOf("American", "Italian", "Mexican", "Japanese", "Chinese")

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp)
    ) {
        items(countries) { country ->
            Text(
                text = country,
                fontSize = 20.sp,
                color = Color.White,
                modifier = Modifier.padding(vertical = 8.dp)
            )

            LazyRow(
                horizontalArrangement = Arrangement.spacedBy(16.dp),
            ) {
                val recipesForCountry = when (country) {
                    "American" -> homeUiState.americans
                    "Italian" -> homeUiState.italian
                    "Mexican" -> homeUiState.mexican
                    "Japanese" -> homeUiState.japanese
                    "Chinese" -> homeUiState.chinese
                    else -> emptyList()
                }

                items(recipesForCountry) { recipe ->
                    RecipeCard(
                        imageRes = recipe.strMealThumb,
                        title = recipe.strMeal
                    )
                }
            }
        }
    }
}