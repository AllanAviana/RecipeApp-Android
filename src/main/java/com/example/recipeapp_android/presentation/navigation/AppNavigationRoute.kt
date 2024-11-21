package com.example.recipeapp_android.presentation.navigation

sealed class Routes(val route: String){
    object WelcomeScreen: Routes("welcome_screen")
    object HomeScreen: Routes("home_screen")
    object DetailsScreen: Routes("details_screen")
    object FavoriteScreen: Routes("favorite_screen")

}