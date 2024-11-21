package com.example.recipeapp_android.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.recipeapp_android.presentation.screens.home.HomeScreen
import com.example.recipeapp_android.presentation.screens.welcome.WelcomeScreen
import com.example.recipeapp_android.presentation.viewmodel.RecipeViewModel

@Composable
fun AppNavGraph(navController: NavHostController = rememberNavController()){
    val recipeViewModel: RecipeViewModel = viewModel()

    NavHost(
        navController = navController,
        startDestination = "welcome_screen"
    ){
        composable("welcome_screen"){
            WelcomeScreen(recipeViewModel, navController)
        }
        composable("home_screen"){
            HomeScreen(recipeViewModel)
        }
    }
}
