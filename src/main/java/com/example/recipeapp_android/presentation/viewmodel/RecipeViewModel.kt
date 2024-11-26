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

    private val _details = MutableStateFlow<DetailsUiState<Details>>(DetailsUiState.Loading)
    val details = _details.asStateFlow()


    init {
        fetchRecipesByCountry()
        fetchRecipeDescription("52772")
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

    fun fetchRecipeDescription(recipeId: String) {
        viewModelScope.launch {
            _details.value = DetailsUiState.Loading
            try {
                var currentDetails = Details()

                val description = recipeRepository.getRecipeDescription(recipeId)
                        Log.d("RecipeViewModel2", "Recipe Description: $description")

                 currentDetails = Details(
                    image = description.meals[0].strMealThumb,
                    name = description.meals[0].strMeal,
                    ingredients = listOfNotNull(
                        description.meals[0].strIngredient1,
                        description.meals[0].strIngredient2,
                        description.meals[0].strIngredient3,
                        description.meals[0].strIngredient4,
                        description.meals[0].strIngredient5,
                        description.meals[0].strIngredient6,
                        description.meals[0].strIngredient7,
                        description.meals[0].strIngredient8,
                        description.meals[0].strIngredient9,
                        description.meals[0].strIngredient10,
                        description.meals[0].strIngredient11,
                        description.meals[0].strIngredient12,
                        description.meals[0].strIngredient13,
                        description.meals[0].strIngredient14,
                        description.meals[0].strIngredient15,
                        description.meals[0].strIngredient16,
                        description.meals[0].strIngredient17,
                        description.meals[0].strIngredient18,
                        description.meals[0].strIngredient19,
                        description.meals[0].strIngredient20
                    ),
                    instructions = description.meals[0].strInstructions
                )

                _details.value = DetailsUiState.Success(currentDetails)
                Log.d("RecipeViewModel2", "Current Details: $currentDetails")

        }catch (e: Exception) {
            _details.value = DetailsUiState.Error("Error fetching recipe description: ${e.message}")
            Log.e("RecipeViewModel", "Error fetching recipe description", e)
        }

            }
    }



}