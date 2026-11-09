package com.quadrize.recipe

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class RecipeViewModel : ViewModel() {
    private val _searchText = MutableStateFlow("")
    private val _selectedCategory = MutableStateFlow("All")
    val selectedCategory = _selectedCategory.asStateFlow()
    val searchText = _searchText.asStateFlow()

    fun onSearchTextChange(text: String) {
        _searchText.value = text
    }

    fun onCategoryChange(category: String) {
        _selectedCategory.value = category
    }

    fun getSearchResults(text: String): List<Recipe> {
        return recipes.filter {
            it.name.contains(text, ignoreCase = true)
        }
    }


    fun getFilteredRecipes(category: String): List<Recipe> {
        return when (category) {
            "Popular" -> recipes.filter { it.name == "Burger" }
            "Easy to make" -> recipes.filter { it.difficulty == "Easy" }
            "Complicated" -> recipes.filter { it.difficulty == "Hard" }
            "Low level" -> recipes.filter { it.level == "0 Уровень" }
            else -> recipes
        }
    }
    fun getRecipes(text: String, category: String): List<Recipe> {
        val searchResults = getSearchResults(text)
        val categoryResults = getFilteredRecipes(category)

        return searchResults.filter { it in categoryResults }
    }
}
