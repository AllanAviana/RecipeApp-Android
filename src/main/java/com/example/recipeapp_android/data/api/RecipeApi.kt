package com.example.recipeapp_android.data.api

import com.example.recipeapp_android.data.remote.model.DescriptionMealResponse
import com.example.recipeapp_android.data.remote.model.MealsResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface RecipeApi {
    @GET("filter.php")
    suspend fun getRecipes(@Query("a") area: String): MealsResponse

    @GET("lookup.php")
    suspend fun getRecipeDescription(@Query("i") recipeId: String): DescriptionMealResponse
}

