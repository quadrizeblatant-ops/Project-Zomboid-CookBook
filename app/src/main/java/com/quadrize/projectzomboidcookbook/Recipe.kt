package com.quadrize.projectzomboidcookbook

data class Recipe(
    val name: String,
    val difficulty: String,
    val cookingTime: Int
)

val recipes = listOf(
    Recipe("Vegetable Soup","Easy", 20),
    Recipe("Stew","Medium", 35),
    Recipe("Bolognese", "Medium", 30),
    Recipe("Beans", "Easy", 10)
)