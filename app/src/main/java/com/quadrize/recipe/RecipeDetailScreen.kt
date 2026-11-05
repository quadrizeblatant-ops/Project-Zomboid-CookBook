package com.quadrize.recipe

import android.content.ActivityNotFoundException
import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.quadrize.homeScreen.AppBackgroundGradient

@Composable
fun RecipeDetailScreen(recipe: Recipe) {
    val context = LocalContext.current
    var showRateDialog by remember { mutableStateOf(checkAndMarkFirstRecipeClick(context)) }

    if (showRateDialog) {
        RateAppDialog(
            onDismiss = { showRateDialog = false },
            onRateClick = {
                showRateDialog = false
                openPlayStore(context)
            }
        )
    }

    AppBackgroundGradient {
        LazyColumn(
            contentPadding = WindowInsets.navigationBars.asPaddingValues(),
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

private fun checkAndMarkFirstRecipeClick(context: Context): Boolean {
    val prefs = context.getSharedPreferences("app_settings", Context.MODE_PRIVATE)
    val hasShownDialog = prefs.getBoolean("has_shown_rate_dialog", false)
    if (!hasShownDialog) {
        prefs.edit().putBoolean("has_shown_rate_dialog", true).apply()
        return true
    }
    return false
}

private fun openPlayStore(context: Context) {
    val packageName = context.packageName
    val uri = Uri.parse("market://details?id=$packageName")
    val goToMarket = Intent(Intent.ACTION_VIEW, uri).apply {
        addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY or Intent.FLAG_ACTIVITY_NEW_DOCUMENT or Intent.FLAG_ACTIVITY_MULTIPLE_TASK)
    }
    try {
        context.startActivity(goToMarket)
    } catch (_: ActivityNotFoundException) {
        context.startActivity(
            Intent(
                Intent.ACTION_VIEW,
                Uri.parse("http://play.google.com/store/apps/details?id=$packageName")
            )
        )
    }
}

@Composable
fun RateAppDialog(
    onDismiss: () -> Unit,
    onRateClick: () -> Unit
) {
    AlertDialog(
        onDismissRequest = onDismiss,
        title = {
            Text(
                text = "Оцените приложение",
                style = MaterialTheme.typography.titleLarge,
                color = Color(0xFFD5D0B8)
            )
        },
        text = {
            Text(
                text = "Вам нравится наше приложение? Пожалуйста, оставьте отзыв в Google Play!",
                style = MaterialTheme.typography.bodyMedium,
                color = Color(0xFFD5D0B8)
            )
        },
        confirmButton = {
            TextButton(onClick = onRateClick) {
                Text(
                    text = "Оценить",
                    color = Color(0xFF667A4E),
                    style = MaterialTheme.typography.titleMedium
                )
            }
        },
        dismissButton = {
            TextButton(onClick = onDismiss) {
                Text(
                    text = "Позже",
                    color = Color(0xFF888888),
                    style = MaterialTheme.typography.titleMedium
                )
            }
        },
        containerColor = Color(0xFF292D28),
        shape = RoundedCornerShape(12.dp)
    )
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
            style = MaterialTheme.typography.titleLarge
        )
        Text(
            style = MaterialTheme.typography.bodySmall,
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
            style = MaterialTheme.typography.titleLarge,
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

    HorizontalDivider(
        thickness = 1.5.dp,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 6.dp, vertical = 16.dp),
        color = Color(0xFF667A4E)
    )
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
                style = MaterialTheme.typography.titleSmall
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
            .padding(horizontal = 4.dp)
    ) {
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
                InfoCard(title = "Сложность", value = recipe.difficulty)
            }
            Column(
                modifier = Modifier
                    .weight(1f)
            ) {
                InfoCard(title = "Кулинария", value = recipe.level)
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
                style = MaterialTheme.typography.titleSmall
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
                .padding(vertical = 12.dp)
        ) {
            Text(
                style = MaterialTheme.typography.titleLarge,
                text = "Вам понадобится:"
            )
            Text(
                text = recipe.ingredients,
                style = MaterialTheme.typography.bodySmall
            )
        }
    }
}