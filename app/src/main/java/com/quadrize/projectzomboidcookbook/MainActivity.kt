package com.quadrize.projectzomboidcookbook

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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
        modifier = Modifier.padding(horizontal = 16.dp)
//        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            style = MaterialTheme.typography.headlineLarge,
            text = "Tired of searching for recipe?",
            color = MaterialTheme.colorScheme.onBackground
        )
        Spacer(
            modifier = Modifier.height(12.dp)
        )
        Text(
            style = MaterialTheme.typography.headlineSmall,
            text = "Lots of various recipes collected here",
            color = MaterialTheme.colorScheme.onBackground
        )

    }
}

@Composable
fun StartButton(onClick: () -> Unit) {
    Button(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(),
        contentPadding = PaddingValues(12.dp),
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
fun ColumnScope.StartBackgroundImage() {
    Image(
        contentDescription = ",",
        painter = painterResource(R.drawable.spiffo_background),
        modifier = Modifier
            .fillMaxWidth()
            .weight(1f),
        contentScale = ContentScale.Crop
    )
}

@Composable
fun WelcomeScreen(
    onStartClick: () -> Unit
) {
//    Scaffold { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding()
                .background(Color.Black)
                .systemBarsPadding()
            ,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            StartBackgroundImage()
            AppHeader()
            StartButton(onStartClick)
        }
//    }
}



@Composable
@Preview
fun AppHeaderPreview() {
    AppHeader()
}

@Composable
@Preview
fun ScreenPreview() {
    WelcomeScreen {}
}