package com.example.aprendekotlinen30dias

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Devices.PIXEL_7_PRO
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.aprendekotlinen30dias.LessonData.kotlinDays
import com.example.aprendekotlinen30dias.ui.theme.AprendeKotlinEn30DiasTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AprendeKotlinEn30DiasTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    topBar = { MyTopAppBar() }
                ) { innerPadding ->
                    DailyRoadmapScreen(innerPadding)
                }
            }
        }
    }
}

@Composable
fun DailyRoadmapScreen(innerPadding: PaddingValues) {
    Column(
        verticalArrangement = Arrangement.spacedBy(10.dp),
        modifier = Modifier
            .fillMaxSize()
            .padding(
                top = innerPadding.calculateTopPadding()
            )
            .padding(start = 8.dp, end = 8.dp)
    ) {
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            item {
                Spacer(modifier = Modifier.height(20.dp))
            }
            item {
                Text(
                    stringResource(R.string.daily_roadmap),
                    style = MaterialTheme.typography.titleLarge
                )
            }
            item {
                Spacer(modifier = Modifier.height(10.dp))
            }
            items(kotlinDays) {
                KotlinDayCard(
                    it,
                    Modifier.fillMaxWidth(),
                    titleTextStyle = TextStyle(
                        fontSize = MaterialTheme.typography.titleLarge.fontSize,
                        color = MaterialTheme.colorScheme.primary,
                        fontFamily = MaterialTheme.typography.titleLarge.fontFamily
                    ),
                    contentPadding = PaddingValues(20.dp, 10.dp)
                )
            }
            item {
                Spacer(modifier = Modifier.height(60.dp))
            }
        }
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true,
    device = PIXEL_7_PRO
)
@Composable
fun DailyRoadmapScreenPreview() {
    AprendeKotlinEn30DiasTheme {
        DailyRoadmapScreen(PaddingValues(10.dp, 40.dp))
    }
}