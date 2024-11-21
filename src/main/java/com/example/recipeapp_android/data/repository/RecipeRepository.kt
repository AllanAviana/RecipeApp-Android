package com.example.recipeapp_android.data.repository

import com.example.recipeapp_android.data.api.RecipeApi
import com.example.recipeapp_android.data.remote.model.MealsResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class RecipeRepository @Inject constructor(
    private val recipeApi: RecipeApi
) {

    suspend fun getRecipesByCountry(country: String): MealsResponse{
        return withContext(Dispatchers.IO){
            try {
                recipeApi.getRecipes(country)
            } catch (e: Exception){
                MealsResponse(emptyList())
            }
        }
    }
}