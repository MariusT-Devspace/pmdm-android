package com.example.cuadriculacursos

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.cuadriculacursos.DataSource.topics
import com.example.cuadriculacursos.ui.theme.CuadriculaCursosTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CuadriculaCursosTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    TopicsScreen(innerPadding)
                }
            }
        }
    }
}

@Composable
fun TopicsScreen(innerPadding: PaddingValues) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = Modifier.padding(horizontal = 8.dp, vertical = innerPadding.calculateTopPadding()),
        horizontalArrangement = Arrangement.spacedBy(6.dp),
        verticalArrangement = Arrangement.spacedBy(6.dp)
    ) {
        items(topics) { topic ->
            TopicCard(
                topic,
                modifier = Modifier.requiredHeight(68.dp),
                imageSize = 68.dp,
                contentPadding = PaddingValues(
                    10.dp, 16.dp, 10.dp, 0.dp
                ),
                titleTextStyle = TextStyle(
                    fontSize = MaterialTheme.typography.bodyMedium.fontSize,
                    lineHeight = MaterialTheme.typography.bodyMedium.lineHeight
                ),
                coursesNumberTextStyle = TextStyle(
                    fontSize = MaterialTheme.typography.labelMedium.fontSize,
                    lineHeight = MaterialTheme.typography.labelMedium.lineHeight
                )
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TopicCardPreview() {
    CuadriculaCursosTheme {
        TopicCard(topics[0], imageSize = 68.dp)
    }
}

@Preview(showBackground = true)
@Composable
fun AppPreview() {
    CuadriculaCursosTheme {
        TopicsScreen(PaddingValues(16.dp))
    }
}