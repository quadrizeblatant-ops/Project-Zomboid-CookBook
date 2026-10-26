package com.quadrize.projectzomboidcookbook

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
}