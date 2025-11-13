package com.cvetyshayasiren.aiphotosession.ui.main

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.widthIn
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.unit.dp
import com.cvetyshayasiren.aiphotosession.Config
import com.cvetyshayasiren.aiphotosession.ui.widgets.ThemeSwitcherWidget

@Composable
fun MainScreenView(
    modifier: Modifier = Modifier,
) {
    val isReady = remember { MainViewModel.isReady() }.collectAsState()
    val scrollState = rememberScrollState()
    val alpha = remember { Animatable(1f) }
    val isSplash = derivedStateOf { !(isReady.value && alpha.value == 0f) }

    LaunchedEffect(isReady.value) {
        if(isReady.value) {
            alpha.animateTo(
                targetValue = 0f,
                animationSpec = tween(delayMillis = 500, durationMillis = 2000)
            )
        }
    }

    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center
    ) {
        PhotoSessionScreen(
            modifier = Modifier
                .verticalScroll(scrollState)
                .widthIn(
                    min = Config.minContentWidth,
                    max = Config.maxContentWidth
                )
        )
        ThemeSwitcherWidget(
            modifier = Modifier.align(Alignment.TopEnd)
        )
        VerticalScrollbar(
            adapter = rememberScrollbarAdapter(scrollState),
            modifier = Modifier
                .align(Alignment.CenterEnd)
                .fillMaxHeight()
        )


        if(isSplash.value) {
            SplashScreen(
                modifier = Modifier
                    .fillMaxSize()
                    .background(MaterialTheme.colorScheme.surface.copy(alpha = alpha.value * 2))
                    .alpha(alpha.value)
            )
        }
    }
}