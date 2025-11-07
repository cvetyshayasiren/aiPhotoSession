package com.cvetyshayasiren.aiphotosession.ui.utils

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.AnimationSpec
import androidx.compose.animation.core.AnimationVector1D
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.repeatable
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.ContentDrawScope
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.LayoutCoordinates
import androidx.compose.ui.layout.Measurable
import androidx.compose.ui.layout.MeasureResult
import androidx.compose.ui.layout.MeasureScope
import androidx.compose.ui.layout.onFirstVisible
import androidx.compose.ui.layout.onLayoutRectChanged
import androidx.compose.ui.layout.onPlaced
import androidx.compose.ui.layout.positionInRoot
import androidx.compose.ui.node.DrawModifierNode
import androidx.compose.ui.node.GlobalPositionAwareModifierNode
import androidx.compose.ui.node.LayoutModifierNode
import androidx.compose.ui.node.ModifierNodeElement
import androidx.compose.ui.unit.Constraints
import androidx.compose.ui.util.lerp
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch

@Composable
fun Modifier.animated(
    threshold: Int = 300,
    scope: CoroutineScope? = null
): Modifier {
    val isVisible = remember { mutableStateOf(false) }
    val fraction = remember { Animatable(0.1f) }
    val scope = scope ?: rememberCoroutineScope()

    return this then Modifier
        .onLayoutRectChanged {
            if(isVisible.value) { return@onLayoutRectChanged }
            if(it.positionInRoot.y < threshold) {
                isVisible.value = true
                scope.launch {
                    print("animate parya")
                    fraction.animateTo(
                        targetValue = 1f,
                        animationSpec = tween(1000)
                    )
                }
            }
        }
        .graphicsLayer {
            translationY = lerp(
                start = threshold.toFloat(),
                stop = 0f,
                fraction = fraction.value
            )
            alpha = fraction.value
        }
}