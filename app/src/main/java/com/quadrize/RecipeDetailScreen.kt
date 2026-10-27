package com.quadrize

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.quadrize.projectzomboidcookbook.Recipe
import com.quadrize.projectzomboidcookbook.recipes
import com.quadrize.projectzomboidcookbook.ui.AppBackground

@Composable
fun RecipeDetailScreen(recipe: Recipe) {
    AppBackground {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .statusBarsPadding()
        ) {
            RecipeInfo(recipe = recipe)
            CalGrid()
        }
    }
}

@Composable
fun RecipeInfo(recipe: Recipe) {
    Column(
        modifier = Modifier.padding(horizontal = 8.dp)
    ) {
        Image(
            modifier = Modifier.size(96.dp),
            contentDescription = "Project Zomboid   Build 42",
            painter = painterResource(recipe.picture)
        )
        Text(
            text = recipe.name,
            style = MaterialTheme.typography.headlineMedium
        )
        Text(
            style = MaterialTheme.typography.headlineSmall,
            text = recipe.description
        )
    }
}

@Composable
fun CalGrid() {
    LazyVerticalGrid(
        GridCells.Fixed(2),
    ) {
        items(recipes) { recipe ->
            CalCard(recipe = recipe)
        }
    }

}
@Composable
fun CalCard(recipe: Recipe) {
    Card(
        modifier = Modifier
            .padding(6.dp)
        ,
        shape = RoundedCornerShape(6.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFF292D28).copy(alpha = 0.5f)
        ),
        border = BorderStroke(2.dp, color = Color(0xFF667A4E))
    ) {
        Text(
            text = recipe.calories.toString()
        )
    }
}