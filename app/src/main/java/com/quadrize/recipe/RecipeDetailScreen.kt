package com.quadrize.recipe

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
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
import com.quadrize.homeScreen.AppBackground

@Composable
fun RecipeDetailScreen(recipe: Recipe) {
    AppBackground {
        LazyColumn(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .statusBarsPadding()
        ) {
            item { RecipeInfo(recipe = recipe) }
            item { InfoCardGrid(recipe = recipe) }
            item { CalGrid(recipe = recipe) }
            item { IngredientsCard(recipe = recipe) }
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
    Column(
        horizontalAlignment = Alignment.Start,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 4.dp)
    ) {
        Text(
            text = "Пищевая ценность:",
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier
                .padding(bottom = 8.dp)
                .padding(horizontal = 6.dp)
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Column(
                modifier = Modifier
                    .weight(1f)
            ) {
                CalCard(title = "Калории", value = recipe.calories)
            }
            Column(
                modifier = Modifier
                    .weight(1f)
            ) {
                CalCard(title = "Белки", value = recipe.protein)
            }
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Column(
                modifier = Modifier
                    .weight(1f)
            ) {
                CalCard(title = "Жиры", value = recipe.fats)
            }
            Column(
                modifier = Modifier
                    .weight(1f)
            ) {
                CalCard(title = "Углеводы", value = recipe.carbs)
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
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 4.dp) // Небольшой отступ по бокам для всей группы
    ) {
        // Обычный Row вместо LazyVerticalGrid
        Row(
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(
                modifier = Modifier
                    .weight(1f)
            ) {
                InfoCard(title = "Время", value = recipe.cookingTime.toString())
            }
            Column(
                modifier = Modifier
                    .weight(1f)
            ) {
                InfoCard(title = "Сложность", value = recipe.difficulty.toString())
            }
            Column(
                modifier = Modifier
                    .weight(1f)
            ) {
                InfoCard(title = "Кулинария", value = recipe.level.toString())
            }
        }

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
fun InfoCard(title: String, value: String) {
    Card(
        shape = RoundedCornerShape(6.dp),
        modifier = Modifier
            .padding(10.dp),
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

@Composable
fun IngredientsCard(recipe: Recipe) {
    Card(
        modifier = Modifier
            .padding(6.dp),
        shape = RoundedCornerShape(6.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFF292D28).copy(alpha = 0.8f)
        )
    ) {
        Column(
            horizontalAlignment = Alignment.Start,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 6.dp)
        ) {
            Text(
                style = MaterialTheme.typography.headlineMedium,
                text = "Вам понадобится:",
                modifier = Modifier
                    .padding(vertical = 12.dp)
            )
            Text(
                text = recipe.ingredients,
                style = MaterialTheme.typography.displaySmall
            )
        }
    }
}