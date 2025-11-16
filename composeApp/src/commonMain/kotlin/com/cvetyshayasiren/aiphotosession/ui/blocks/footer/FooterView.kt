package com.cvetyshayasiren.aiphotosession.ui.blocks.footer

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.repeatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.onFirstVisible
import androidx.compose.ui.text.LinkAnnotation
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withLink
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.lerp
import androidx.compose.ui.util.lerp
import com.cvetyshayasiren.aiphotosession.Config
import com.cvetyshayasiren.aiphotosession.ui.theme.rubikMonoOne
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun FooterView() {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.Start
    ) {
        val animateFloat = remember { Animatable(-4f) }
        val scope = rememberCoroutineScope()

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

        Config.bigSpacer()
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .onFirstVisible(minDurationMs = 200) {
                    scope.launch {
                        animateFloat.animateTo(
                            targetValue = 4f,
                            animationSpec = repeatable(
                                iterations = 4,
                                repeatMode = RepeatMode.Reverse,
                                animation = tween(500)
                            )
                        )
                    }
                },
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Text(
                modifier = Modifier
                    .padding(Config.bigPadding)
                    .graphicsLayer { rotationZ = animateFloat.value },
                text = buildAnnotatedString {
                    withLink(LinkAnnotation.Url("https://t.me/TwoTheJupiter")) {
                        withStyle(
                            style = SpanStyle(
                                color = MaterialTheme.colorScheme.secondary,
                                fontFamily = rubikMonoOne,
                                fontStyle = FontStyle.Italic,
                                fontSize = MaterialTheme.typography.labelSmall.fontSize,
                            )
                        ) {
                            append("[vitalya tg]")
                        }
                    }
                }
            )
            Text(
                modifier = Modifier
                    .padding(Config.bigPadding)
                    .graphicsLayer { rotationZ = animateFloat.value },
                text = buildAnnotatedString {
                    withLink(LinkAnnotation.Url("https://t.me/ilya_special")) {
                        withStyle(
                            style = SpanStyle(
                                color = MaterialTheme.colorScheme.secondary,
                                fontFamily = rubikMonoOne,
                                fontStyle = FontStyle.Italic,
                                fontSize = MaterialTheme.typography.labelSmall.fontSize,
                            )
                        ) {
                            append("[ilya tg]")
                        }
                    }
                }
            )
        }
    }
}