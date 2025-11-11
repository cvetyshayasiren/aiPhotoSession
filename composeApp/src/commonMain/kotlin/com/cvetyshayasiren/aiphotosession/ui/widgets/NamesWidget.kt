package com.cvetyshayasiren.aiphotosession.ui.widgets

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.FastOutLinearInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Camera
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.onFirstVisible
import com.cvetyshayasiren.aiphotosession.ui.theme.rubikMonoOne
import kotlinx.coroutines.launch

@Composable
fun NamesWidget(
    modifier: Modifier = Modifier
) {
    val animateFloat = remember { Animatable(400f) }

    val scope = rememberCoroutineScope()

    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Column(
            modifier = Modifier
                .onFirstVisible {
                    scope.launch {
                        animateFloat.animateTo(
                            targetValue = 0f,
                            animationSpec = tween(durationMillis = 500, easing = FastOutLinearInEasing)
                        )
                    }
                },
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.End
        ) {
            Text(
                text = "~~~I",
                fontFamily = rubikMonoOne,
                fontSize = MaterialTheme.typography.displaySmall.fontSize,
                color = MaterialTheme.colorScheme.secondaryFixed
            )
            Text(
                text = "VITA",
                fontFamily = rubikMonoOne,
                fontSize = MaterialTheme.typography.displaySmall.fontSize,
                color = MaterialTheme.colorScheme.tertiary
            )
        }
        Text(
            modifier = Modifier
                .graphicsLayer {
                    scaleY = 2f
                    translationX = animateFloat.value
                },
            text = "LYA",
            fontFamily = rubikMonoOne,
            fontSize = MaterialTheme.typography.displayLarge.fontSize,
            color = MaterialTheme.colorScheme.primary
        )
    }
}