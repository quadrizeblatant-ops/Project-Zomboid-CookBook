package com.quadrize

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
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
import androidx.compose.material3.HorizontalDivider
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
import java.nio.file.WatchEvent

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
            InfoCardGrid(recipe = recipe)
            CalGrid(recipe = recipe)
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
        HorizontalDivider(
            thickness = 1.5.dp,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 6.dp, vertical = 16.dp),
            color = Color(0xFF667A4E)
        )

    }
}

@Composable
fun CalGrid(recipe: Recipe) {
    val nutritions = listOf(
        Pair("Калории", recipe.calories),
        Pair("Белки", recipe.protein),
        Pair("Жиры", recipe.fats),
        Pair("Углеводы", recipe.carbs),
    )
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Text(
            text = "Пищевая ценность",
            style = MaterialTheme.typography.headlineMedium
        )
        LazyVerticalGrid(
            GridCells.Fixed(2),
            modifier = Modifier.padding(top = 8.dp)
        ) {
            items(nutritions) { nutrition ->
                CalCard(
                    title = nutrition.first,
                    value = nutrition.second
                )
            }
        }
    }
}

@Composable
fun CalCard(title: String, value: Int) {
    Card(
        modifier = Modifier
            .padding(6.dp),
        shape = RoundedCornerShape(6.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFF292D28).copy(alpha = 0.5f)
        ),
        border = BorderStroke(2.dp, color = Color(0xFF667A4E))
    ) {
        Column(
            horizontalAlignment = Alignment.Start,
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    horizontal = 8.dp,
                    vertical = 8.dp
                )
        ) {
            Text(
                text = title,
                style = MaterialTheme.typography.displaySmall
            )
            Text(
                text = value.toString(),
                style = MaterialTheme.typography.headlineSmall
            )
        }
    }
}

@Composable
fun InfoCardGrid(recipe: Recipe) {
    val info = listOf(
        Pair("Время", recipe.cookingTime),
        Pair("Сложность", recipe.difficulty),
        Pair("Кулинария", recipe.level)
    )
    LazyVerticalGrid(
        GridCells.Fixed(3)
    ) {
        items(info) { info ->
            InfoCard(
                title = info.first,
                value = info.second.toString()
            )
        }
    }
    HorizontalDivider(
        thickness = 1.5.dp,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 10.dp, vertical = 16.dp),
        color = Color(0xFF667A4E)
    )
}

@Composable
fun InfoCard(title: String, value: String) {
    Card(
        shape = RoundedCornerShape(6.dp),
        modifier = Modifier
            .padding(10.dp)
        ,
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFF292D28).copy(alpha = 0.8f)
        )
    ) {
        Column(
            horizontalAlignment = Alignment.Start,
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    horizontal = 8.dp,
                    vertical = 8.dp
                )
        ) {
            Text(
                text = title,
                style = MaterialTheme.typography.displaySmall
            )
            Text(
                text = value,
                style = MaterialTheme.typography.headlineSmall
            )
        }
    }
}