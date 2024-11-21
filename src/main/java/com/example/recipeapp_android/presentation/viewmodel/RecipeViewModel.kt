package com.example.recipeapp_android.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.recipeapp_android.data.repository.RecipeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RecipeViewModel @Inject constructor(
    private val recipeRepository: RecipeRepository
): ViewModel() {


    init {
        fetchRecipesByCountry("Canadian")
    }

    private fun fetchRecipesByCountry(country: String){
        viewModelScope.launch {
            val recipes = recipeRepository.getRecipesByCountry(country)

            Log.d("RecipeViewModel", "Recipes: $recipes")
        }

    }

}