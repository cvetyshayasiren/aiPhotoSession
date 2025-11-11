package com.cvetyshayasiren.aiphotosession.ui.utils

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.onFirstVisible
import androidx.compose.ui.util.lerp
import com.cvetyshayasiren.aiphotosession.Config
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun Modifier.animated(
    scope: CoroutineScope? = null
): Modifier {
    val fraction = remember { Animatable(0.1f) }
    val scope = scope ?: rememberCoroutineScope()

    return this then Modifier
        .onFirstVisible(minFractionVisible = Config.FRACTION_VISIBLE_THRESHOLD) {
            scope.launch {
                fraction.animateTo(
                    targetValue = 1f,
                    animationSpec = tween(1000)
                )
            }
        }
        .graphicsLayer {
            translationY = lerp(
                start = 600f,
                stop = 0f,
                fraction = fraction.value
            )
            alpha = fraction.value
        }
}