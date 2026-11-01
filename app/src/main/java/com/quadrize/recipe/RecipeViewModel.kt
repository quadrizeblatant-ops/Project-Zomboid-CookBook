package com.quadrize.recipe

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class RecipeViewModel : ViewModel() {
    private val _searchText = MutableStateFlow("")
    private val _selectedCategory = MutableStateFlow("New")
    val selectedCategory = _selectedCategory.asStateFlow()
    val searchText = _searchText.asStateFlow()

    fun onSearchTextChange(text: String) {
        _searchText.value = text
    }

    fun onCategoryChange(category: String) {
        _selectedCategory.value = category
    }

    fun getFilteredRecipes(category: String): List<Recipe> {
        return when (category) {
            "Popular" -> recipes.filter { it.name == "Burger" }
            "Easy to make" -> recipes.filter { it.difficulty == "Easy"  }
            "Complicated" -> recipes.filter { it.difficulty == "Hard"  }
            "Low level" -> recipes.filter { it.level == "0 Уровень" }
            else -> recipes
        }
    }
}
