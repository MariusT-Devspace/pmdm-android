package com.example.tarjetadepresentacion

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.tarjetadepresentacion.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BusinessCardTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    containerColor = MaterialTheme.colorScheme.surface
                ) { innerPadding ->
                    val configuration = LocalConfiguration.current
                    val padding = when(configuration.orientation) {
                        Configuration.ORIENTATION_PORTRAIT -> PaddingValues(horizontal = 12.dp)
                        else -> PaddingValues(vertical = 12.dp)
                    }
                    BusinessCard(
                        CONTACT_INFO_DATA,
                        Modifier.fillMaxSize()
                            .padding(innerPadding)
                            .padding(padding)
                    )
                }
            }
        }
    }
}

@Composable
fun BusinessCard(
    contactInfoData:  List<ContactInfoItem>,
    modifier: Modifier
) {
    val configuration = LocalConfiguration.current
    when(configuration.orientation) {
        Configuration.ORIENTATION_LANDSCAPE -> {
            Row(modifier) {
                Header(
                    Modifier.fillMaxHeight()
                        .padding(12.dp)
                        .clip(RoundedCornerShape(22.dp))
                        .background(MaterialTheme.colorScheme.primaryContainer)
                        .padding(bottom = 12.dp),
                    imageSize = 180.dp
                )
                ContactInfo(
                    contactInfoData,
                    Modifier.fillMaxHeight()
                        .clip(RoundedCornerShape(18.dp))
                        .background(MaterialTheme.colorScheme.surfaceContainerLowest)
                        .border(1.dp, MaterialTheme.colorScheme.outlineVariant, RoundedCornerShape(18.dp))
                        .padding(horizontal = 12.dp, vertical = 18.dp)
                )
            }
        }

        else -> {
            Column(
                modifier = modifier,
                verticalArrangement = Arrangement.spacedBy(10.dp, Alignment.CenterVertically)
            ) {
                Header(
                    Modifier.fillMaxWidth()
                        .padding(12.dp)
                        .clip(RoundedCornerShape(22.dp))
                        .background(MaterialTheme.colorScheme.primaryContainer)
                        .padding(bottom = 12.dp),
                    imageSize = 230.dp
                )
                ContactInfo(
                    contactInfoData,
                    Modifier.fillMaxWidth()
                        .clip(RoundedCornerShape(18.dp))
                        .background(MaterialTheme.colorScheme.surfaceContainerLowest)
                        .border(1.dp, MaterialTheme.colorScheme.outlineVariant, RoundedCornerShape(18.dp))
                        .padding(horizontal = 12.dp, vertical = 28.dp)
                )
            }
        }


    }


}

@Preview(showBackground = true)
@Composable
fun BusinessCardPreview() {
    BusinessCardTheme {
        BusinessCard(
            CONTACT_INFO_DATA,
            modifier = Modifier.fillMaxSize()
                .padding(12.dp)
        )
    }
}

@Preview(heightDp = 360, widthDp = 800)
@Composable
fun BusinessCardPreviewLandscape() {
    BusinessCardTheme {
        BusinessCard(
            CONTACT_INFO_DATA,
            modifier = Modifier.fillMaxSize()
                .padding(12.dp)
        )
    }
}