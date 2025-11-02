package com.example.tarjetadepresentacion

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tarjetadepresentacion.ui.theme.BusinessCardTheme
import com.example.tarjetadepresentacion.ui.theme.displayFontFamily

@Composable
fun Header(modifier: Modifier = Modifier) {
    Column(
        modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(R.drawable.android_logo),
            null,
            Modifier.width(230.dp)
        )
        Text(
            "Marius Tichieru",
            fontSize = 42.sp,
            fontFamily = displayFontFamily
        )
        Text(
            stringResource(R.string.job_title),
            textAlign = TextAlign.Center,
            modifier = Modifier.width(365.dp)
        )
    }

}

@Preview(showBackground = true)
@Composable
fun HeaderPreview() {
    BusinessCardTheme {
        Header()
    }
}