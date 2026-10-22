package com.quadrize.projectzomboidcookbook

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.quadrize.projectzomboidcookbook.ui.theme.ProjectZomboidCookBookTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge(
            statusBarStyle = SystemBarStyle.dark(
                android.graphics.Color.BLACK
            ),
            navigationBarStyle = SystemBarStyle.dark(
                android.graphics.Color.BLACK
            )
        )
        setContent {
            ProjectZomboidCookBookTheme {
            AppNavigation()
            }
        }
    }
}

@Composable
fun AppHeader() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            style = MaterialTheme.typography.headlineLarge,
            text = "Tired of searching for recipe?",
            modifier = Modifier.padding(start = 18.dp)
        )
        Text(
            style = MaterialTheme.typography.headlineMedium,
            text = "More than 100 recipes of various food",
            modifier = Modifier.padding(top = 12.dp)
        )

    }
}

@Composable
fun StartButton(onClick: () -> Unit) {
    Button(
        modifier = Modifier
            .padding(horizontal = 16.dp)
            .padding(top = 16.dp)
            .fillMaxWidth(),
        onClick = onClick,
        shape = RoundedCornerShape(10.dp)
    ) {
        Text(
            "Begin",
            style = MaterialTheme.typography.headlineMedium,
            color = Color.Black
        )
    }
}

@Composable
fun StartBackgroundImage() {
    Image(
        contentDescription = ",",
        painter = painterResource(R.drawable.spiffo),
        modifier = Modifier
            .size(640.dp)
    )
}

@Composable
fun WelcomeScreen(
    onStartClick: () -> Unit
) {
    Scaffold { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            StartBackgroundImage()
            AppHeader()
            StartButton(onStartClick)
        }
    }
}


@Composable
@Preview
fun AppHeaderPreview() {
    AppHeader()
}