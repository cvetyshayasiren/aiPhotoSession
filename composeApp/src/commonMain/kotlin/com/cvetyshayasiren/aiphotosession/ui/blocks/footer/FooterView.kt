package com.cvetyshayasiren.aiphotosession.ui.blocks.footer

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.text.LinkAnnotation
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withLink
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import com.cvetyshayasiren.aiphotosession.Config
import com.cvetyshayasiren.aiphotosession.ui.theme.rubikMonoOne

@Composable
fun FooterView() {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.Start
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(Config.smallSpacerDp * 6)
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(
                            MaterialTheme.colorScheme.surfaceVariant,
                            MaterialTheme.colorScheme.surface
                        )
                    )
                )
        )
        Text(
            modifier = Modifier.padding(12.dp).fillMaxWidth(.8f).align(Alignment.Start),
            text = "Ну вот и всё, нейродундучки на том закончились вдруг",
            fontFamily = rubikMonoOne,
            fontSize = MaterialTheme.typography.bodyMedium.fontSize,
            color = MaterialTheme.colorScheme.tertiaryFixedDim
        )
        Text(
            modifier = Modifier.padding(12.dp).fillMaxWidth(.6f).align(Alignment.End),
            text = "ну всё по домам тогда",
            fontFamily = rubikMonoOne,
            fontSize = MaterialTheme.typography.bodyMedium.fontSize,
            color = MaterialTheme.colorScheme.primary
        )
        Text(
            modifier = Modifier.padding(12.dp),
            text = buildAnnotatedString {
                withLink(LinkAnnotation.Url("https://t.me/TwoTheJupiter")) {
                    withStyle(
                        style = SpanStyle(
                            color = MaterialTheme.colorScheme.secondary,
                            fontFamily = rubikMonoOne,
                            fontSize = MaterialTheme.typography.labelSmall.fontSize,
                        )
                    ) {
                        append("vitalya tg")
                    }
                }
            }
        )
    }
}