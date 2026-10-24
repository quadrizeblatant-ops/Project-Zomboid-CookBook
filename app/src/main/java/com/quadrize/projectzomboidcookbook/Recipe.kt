package com.quadrize.projectzomboidcookbook

data class Recipe(
    val name: String,
    val difficulty: String,
    val cookingTime: Int
)

val recipes = listOf(
    Recipe("Vegetable Soup","Easy", 20),
    Recipe("Stew","Medium", 35)
)