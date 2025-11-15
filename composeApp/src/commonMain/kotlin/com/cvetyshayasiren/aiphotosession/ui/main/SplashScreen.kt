package com.cvetyshayasiren.aiphotosession.ui.main

import androidx.compose.foundation.background
import androidx.compose.foundation.basicMarquee
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Camera
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.TileMode
import androidx.compose.ui.graphics.TransformOrigin
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.unit.dp
import com.cvetyshayasiren.aiphotosession.Config
import com.cvetyshayasiren.aiphotosession.ui.theme.rubikMonoOne

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SplashScreen(
    modifier: Modifier
) {
    val progress = remember { MainViewModel.progress() }.collectAsState()
    val phrases = remember { MainViewModel.progressPhrases() }.collectAsState()

    Column(
        modifier = modifier
            .background(
                brush = Brush.horizontalGradient(
                    colorStops = arrayOf(
                        0.0f to MaterialTheme.colorScheme.surface,
                        progress.value.fraction to MaterialTheme.colorScheme.surface,
                        1f to MaterialTheme.colorScheme.surfaceBright
                    ),
                    tileMode = TileMode.Clamp
                )
            )
        ,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column(
            modifier = Modifier
                .widthIn(
                    min = Config.minContentWidth,
                    max = Config.maxContentWidth
                )
                .fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.Start
        ) {
            Text(
                modifier = Modifier
                    .padding(start = Config.smallPadding)
                    .graphicsLayer {
                        scaleX = 2f
                        transformOrigin = TransformOrigin(pivotFractionX = 0f, pivotFractionY = .5f)
                    },
                text = "AI",
                fontSize = MaterialTheme.typography.displayLarge.fontSize,
                fontFamily = rubikMonoOne,
                color = MaterialTheme.colorScheme.primary
            )
            Text(
                modifier = Modifier.basicMarquee().padding(Config.bigPadding),
                text = " PHOTO",
                fontSize = MaterialTheme.typography.displayMedium.fontSize,
                fontFamily = rubikMonoOne,
                color = MaterialTheme.colorScheme.secondary
            )
            Text(
                modifier = Modifier.basicMarquee().padding(Config.bigPadding),
                text = "  SESSION",
                fontSize = MaterialTheme.typography.displaySmall.fontSize,
                fontFamily = rubikMonoOne,
                color = MaterialTheme.colorScheme.error
            )
            Text(
                modifier = Modifier.padding(Config.smallSpacerDp),
                text = "progress ${progress.value.prettyPercent()} ${phrases.value}",
                fontSize = MaterialTheme.typography.bodySmall.fontSize,
                fontFamily = rubikMonoOne
            )
            Slider(
                enabled = false,
                value = progress.value.fraction,
                onValueChange = { },
                thumb = {
                    Icon(
                        modifier = Modifier.size(Config.smallSpacerDp * 2),
                        imageVector = Icons.Outlined.Camera,
                        contentDescription = "camera icon"
                    )
                }
            )
            Config.smallSpacer()
        }

        Text(
            modifier = Modifier.align(Alignment.End).padding(Config.smallSpacerDp),
            text = "емое",
            fontSize = MaterialTheme.typography.displaySmall.fontSize,
            fontFamily = rubikMonoOne,
            color = MaterialTheme.colorScheme.surfaceBright
        )
    }
}