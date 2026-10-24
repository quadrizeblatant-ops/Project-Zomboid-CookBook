package com.quadrize.projectzomboidcookbook.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.input.TextFieldState
import androidx.compose.material3.Button
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.quadrize.projectzomboidcookbook.AppNavigation
import androidx.compose.runtime.*
import com.quadrize.projectzomboidcookbook.Recipe
import com.quadrize.projectzomboidcookbook.recipes
import com.quadrize.projectzomboidcookbook.ui.theme.ProjectZomboidCookBookTheme

@Composable
fun HomeScreen() {
    Scaffold { innerPadding ->
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            SearchBar()
            Categories()
            RecipeGrid(modifier = Modifier
                .weight(1f)
                .padding(horizontal = 16.dp)
            )

        }
    }
}


@Composable
fun SearchBar() {
    var searchText by remember { mutableStateOf("") }
    Column(
        horizontalAlignment = Alignment.Start
    ) {
        Text(
            modifier = Modifier
                .padding(12.dp),
            text = "Looking for something?",
            style = MaterialTheme.typography.headlineMedium,
            color = MaterialTheme.colorScheme.onBackground
        )
        OutlinedTextField(
            colors = OutlinedTextFieldDefaults.colors(
                focusedContainerColor = Color(0xFF292D28),
                unfocusedContainerColor = Color(0xFF292D28),
                focusedBorderColor = Color(0xFF667A4E),
                unfocusedBorderColor = Color(0xFF667A4E)
            ),
            shape = RoundedCornerShape(12.dp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 12.dp),
            value = searchText,
            onValueChange = { searchText = it },
            placeholder = {
                Text(
                    text = "Search here...",
                    style = MaterialTheme.typography.headlineSmall
                )
            }
        )
    }
}

@Composable
fun TestFilterChip() {
    val testCategories = listOf(
        "Test 1",
        "Test 2",
        "Test 3"
    )
    val selectedCategory by remember {
        mutableStateOf("Test 1")
    }
    LazyRow() {
    }
}

@Composable
fun Categories(modifier: Modifier = Modifier) {
    val categories = listOf(
        "New",
        "Popular",
        "Easy to make",
        "Complicated",
        "Low level"
    )

    var selectedCategory by remember {
        mutableStateOf("New")
    }

    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(10.dp),
        modifier = Modifier
            .padding(12.dp)
    ) {
        items(categories) { category ->
            FilterChip(
                selected = selectedCategory == category,
                onClick = {
                    selectedCategory = category
                },
                label = {
                    Text(
                        text = category,
                        style = MaterialTheme.typography.headlineSmall
                    )
                },
                shape = RoundedCornerShape(12.dp),
                colors = FilterChipDefaults.filterChipColors(
                    selectedContainerColor = Color(0xFF667A4E),
                    selectedLabelColor = Color.White,
                    containerColor = Color(0xFF292D28),
                    labelColor = Color(0xFFD5D0B8)
                ),
                border = FilterChipDefaults.filterChipBorder(
                    enabled = true,
                    selected = selectedCategory == category,
                    borderColor = Color(0xFF667A4E),
                    selectedBorderColor = Color(0xFF667A4E)
                )
            )
        }
    }
}

@Composable
fun RecipeGrid(modifier: Modifier = Modifier) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = modifier,
    ) {
        items(recipes) { recipe ->
            RecipeCard(recipe)
        }
    }
}

@Composable
fun RecipeCard(recipe: Recipe) {
    Column() {
        Text(
            text = recipe.name,
            style = MaterialTheme.typography.headlineSmall
        )
        Text(
            text = recipe.difficulty,
            style = MaterialTheme.typography.headlineSmall
        )
        Text(
            text = recipe.cookingTime.toString(),
            style = MaterialTheme.typography.headlineSmall
        )
    }
}