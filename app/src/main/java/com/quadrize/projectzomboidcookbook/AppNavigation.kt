package com.quadrize.projectzomboidcookbook

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.quadrize.RecipeDetailScreen
import com.quadrize.projectzomboidcookbook.ui.HomeScreen

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "welcome"
    ) {
        composable("welcome") {
            WelcomeScreen(
                onStartClick = {
                    navController.navigate("home")
                }
            )
        }

        composable("home") {
            HomeScreen(navController = navController)
        }

        composable("recipe/{recipeName}") { backStackEntry ->
            val name = backStackEntry.arguments?.getString("recipeName")
            val recipe = recipes.find { it.name == name }

            if (recipe != null) {
                RecipeDetailScreen(recipe = recipe)
            }
        }
    }
}