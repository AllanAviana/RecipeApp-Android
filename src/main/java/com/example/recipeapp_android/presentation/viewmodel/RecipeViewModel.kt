package com.example.recipeapp_android.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.recipeapp_android.data.repository.RecipeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RecipeViewModel @Inject constructor(
    private val recipeRepository: RecipeRepository
): ViewModel() {

    private val _recipes = MutableStateFlow<RecipeUiState<HomeUiState>>(RecipeUiState.Loading)
    val recipes = _recipes.asStateFlow()


    init {
        fetchRecipesByCountry()
    }

     fun fetchRecipesByCountry() {
        viewModelScope.launch {
            _recipes.value = RecipeUiState.Loading

            delay(5000)

            try {
                val countries = listOf("American", "Italian", "Mexican", "Japanese", "Chinese")

                var currentState = HomeUiState()

                countries.forEach { country ->
                    val recipes = recipeRepository.getRecipesByCountry(country).meals
                    Log.d("RecipeViewModel", "Recipes for $country: $recipes")
                    currentState = when (country) {
                        "American" -> currentState.copy(americans = recipes)
                        "Italian" -> currentState.copy(italian = recipes)
                        "Mexican" -> currentState.copy(mexican = recipes)
                        "Japanese" -> currentState.copy(japanese = recipes)
                        "Chinese" -> currentState.copy(chinese = recipes)
                        else -> currentState
                    }
                    Log.d("RecipeViewModel", "Current State: $currentState")
                }

                _recipes.value = RecipeUiState.Success(currentState)
            } catch (e: Exception) {
                _recipes.value = RecipeUiState.Error("Error fetching recipes: ${e.message}")
                Log.e("RecipeViewModel", "Error fetching recipes", e)
            }
        }
    }
}