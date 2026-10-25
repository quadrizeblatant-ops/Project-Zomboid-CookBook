package com.quadrize.projectzomboidcookbook

import android.graphics.Picture
import android.media.Image

data class Recipe(
    val name: String,
    val difficulty: String,
    val cookingTime: Int,
    val picture: Int
)

val recipes = listOf(
    Recipe("Veggie Soup","Easy", 20, R.drawable.soup_bowl),
    Recipe("Sandwich","Medium", 15, R.drawable.sandwich),
    Recipe("Taco", "Medium", 15, R.drawable.taco),
    Recipe("Beans", "Easy", 10, R.drawable.beans_can),
    Recipe("Burger", "Hard", 20, R.drawable.burger),
    Recipe("Sushi", "Medium", 15, R.drawable.sushi),
    Recipe("Craft Salad", "Hard", 30, R.drawable.craft_salad),
    Recipe("Steak", "Medium", 15, R.drawable.steak),
)