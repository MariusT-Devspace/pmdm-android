package com.example.tarjetadepresentacion

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tarjetadepresentacion.ui.theme.BusinessCardTheme

@Composable
fun ContactInfo(contactInfoData:  List<ContactInfoItem>, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        contactInfoData.forEach {
            ContactInfoItem(it, MaterialTheme.colorScheme.secondary)
        }
    }
}

@Composable
fun ContactInfoItem(
    contactInfoItem: ContactInfoItem,
    iconColor: Color? = null
) {
    Row {
        Icon(
            painter = painterResource(contactInfoItem.icon),
            contactInfoItem.description,
            tint = iconColor ?: MaterialTheme.colorScheme.onSurface,
        )
        Spacer(Modifier.size(15.dp))
        Text(
            contactInfoItem.info,
            color = MaterialTheme.colorScheme.onPrimaryFixed,
            fontSize = 18.sp
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ContactInfoPreview() {
    BusinessCardTheme {
        ContactInfo(contactInfoData = CONTACT_INFO_DATA)
    }
}