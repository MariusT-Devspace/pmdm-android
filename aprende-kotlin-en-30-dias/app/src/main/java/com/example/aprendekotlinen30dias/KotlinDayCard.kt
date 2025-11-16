package com.example.aprendekotlinen30dias

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Devices.PIXEL_7_PRO
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.aprendekotlinen30dias.LessonData.kotlinDays
import com.example.aprendekotlinen30dias.model.KotlinDay
import com.example.aprendekotlinen30dias.ui.theme.AprendeKotlinEn30DiasTheme

@Composable
fun KotlinDayCard(
    kotlinDay: KotlinDay,
    modifier: Modifier = Modifier,
    titleTextStyle: TextStyle = TextStyle(),
    contentPadding: PaddingValues = PaddingValues(10.dp)
) {
    val (isExpanded, onClick) = remember { mutableStateOf(false) }

    ElevatedCard(
        elevation = CardDefaults.cardElevation(
            defaultElevation = 6.dp
        ),
        modifier = modifier
            .width(240.dp)
            .padding(top = 10.dp),
        shape = RoundedCornerShape(20.dp),
        onClick = { onClick(!isExpanded) }
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(12.dp),
            modifier = Modifier.fillMaxSize()
                .animateContentSize(
                    animationSpec = spring(
                        dampingRatio = Spring.DampingRatioMediumBouncy,
                        stiffness = Spring.StiffnessMediumLow
                    )
                )
        ) {
            Box(modifier = Modifier.fillMaxWidth()) {
                Image(
                    painterResource(kotlinDay.iconRes),
                    null,
                    Modifier
                        .fillMaxWidth()
                        .requiredHeight(200.dp)
                        .clip(RoundedCornerShape(20.dp)),
                    contentScale = ContentScale.Crop
                )
                Text(
                    stringResource(R.string.dia, kotlinDay.day),
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    style = TextStyle(
                        fontSize = MaterialTheme.typography.titleMedium.fontSize,
                        lineHeight = MaterialTheme.typography.titleMedium.lineHeight
                    ),
                    modifier = Modifier
                        .padding(10.dp)
                        .clip(RoundedCornerShape(20.dp))
                        .background(MaterialTheme.colorScheme.tertiaryContainer)
                        .padding(18.dp, 8.dp)
                )
            }

            Column(
                verticalArrangement = Arrangement.spacedBy(8.dp),
                modifier = Modifier.padding(contentPadding)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = stringResource(kotlinDay.titleRes),
                        style = titleTextStyle
                    )
                    Spacer(Modifier.weight(1f))

                    val icon = if (isExpanded)
                        R.drawable.chevron_up
                    else
                        R.drawable.chevron_down
                    Icon(
                        painter = painterResource(icon),
                        contentDescription = stringResource(R.string.click_to_read_more),
                        tint = MaterialTheme.colorScheme.secondary
                    )

                }

                Text(
                    stringResource(kotlinDay.descriptionRes),
                    maxLines = if (isExpanded) Int.MAX_VALUE else 2,
                    overflow = TextOverflow.Ellipsis
                )

            }
        }

    }
}

@Preview(
    showBackground = true,
    device = PIXEL_7_PRO
)
@Composable
fun KotlinDayCardPreview() {
    AprendeKotlinEn30DiasTheme {
        KotlinDayCard(kotlinDay = kotlinDays[0])
    }
}