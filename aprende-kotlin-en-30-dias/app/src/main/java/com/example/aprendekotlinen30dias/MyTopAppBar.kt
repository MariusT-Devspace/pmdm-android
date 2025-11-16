package com.example.aprendekotlinen30dias

import androidx.compose.foundation.Image
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.aprendekotlinen30dias.ui.theme.AprendeKotlinEn30DiasTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTopAppBar() {
    TopAppBar(
        title = { Text(
            stringResource(R.string.aprende_kotlin_en_30_dias),
            color = MaterialTheme.colorScheme.primary
        ) },
        navigationIcon = { Image(
            painterResource(R.drawable.kotlin_mascot),
            null
        ) }
    )
}

@Preview
@Composable
fun MyTopAppBarPreview() {
    AprendeKotlinEn30DiasTheme {
        MyTopAppBar()
    }
}