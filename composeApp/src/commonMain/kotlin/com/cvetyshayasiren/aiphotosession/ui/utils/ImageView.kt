package com.cvetyshayasiren.aiphotosession.ui.utils

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.onFirstVisible
import androidx.compose.ui.unit.IntOffset
import com.cvetyshayasiren.aiphotosession.Config
import com.cvetyshayasiren.aiphotosession.data.ImageOpt
import com.cvetyshayasiren.aiphotosession.ui.main.MainViewModel
import com.cvetyshayasiren.aiphotosession.ui.theme.rubikMonoOne
import com.github.panpf.sketch.AsyncImage
import com.github.panpf.sketch.rememberAsyncImageState
import com.github.panpf.sketch.request.LoadState
import dev.chrisbanes.haze.hazeEffect
import dev.chrisbanes.haze.hazeSource
import dev.chrisbanes.haze.materials.ExperimentalHazeMaterialsApi
import dev.chrisbanes.haze.materials.HazeMaterials
import dev.chrisbanes.haze.rememberHazeState
import kotlinx.coroutines.launch
import kotlin.math.PI
import kotlin.math.sin

@Composable
fun ImageView(
    modifier: Modifier = Modifier,
    image: ImageOpt,
    animated: Boolean = true,
    aspectRatio: Float? = null,
    contentScale: ContentScale = ContentScale.Fit,
    colorFilter: ColorFilter? = null
) {
    val aspectRatio = remember { aspectRatio ?: image.getRatio() }

    val state = rememberAsyncImageState()
    val loadState: LoadState? = state.loadState

    when (loadState) {
        is LoadState.Started -> { MainViewModel.addInLoadingQueue(image) }
        else -> { MainViewModel.onLoadingSuccess(image) }
    }

    AsyncImage(
        state = state,
        modifier = modifier
            .aspectRatio(aspectRatio)
            .then(if(animated) Modifier.animated() else Modifier)
            .shadow(Config.shadowElevation),
        uri = image.getUri(),
        contentDescription = "photo",
        contentScale = contentScale,
        colorFilter = colorFilter
    )
}

@OptIn(ExperimentalHazeMaterialsApi::class)
@Composable
fun ImageView(
    modifier: Modifier = Modifier,
    image: ImageOpt,
    animated: Boolean = true,
    aspectRatio: Float? = null,
    contentScale: ContentScale = ContentScale.Fit,
    colorFilter: ColorFilter? = null,
    content: @Composable (BoxScope.() -> Unit)
) {
    val hazeState = rememberHazeState()
    Box(
        modifier = Modifier.wrapContentSize(),
        contentAlignment = Alignment.BottomStart
    ) {
        ImageView(
            modifier = modifier
                .hazeSource(hazeState),
            image = image,
            animated = animated,
            aspectRatio = aspectRatio,
            contentScale = contentScale,
            colorFilter = colorFilter
        )
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .hazeEffect(state = hazeState, style = HazeMaterials.ultraThin())
                .padding(Config.defaultSpacerDp),
            contentAlignment = Alignment.CenterStart
        ) {
            content()
        }
    }
}

@Composable
fun ImageView(
    modifier: Modifier = Modifier,
    image: ImageOpt,
    animated: Boolean = true,
    aspectRatio: Float? = null,
    contentScale: ContentScale = ContentScale.Fit,
    colorFilter: ColorFilter? = null,
    isRightLine: Boolean,
    content: @Composable (RowScope.() -> Unit)
) {
    Row(
        verticalAlignment = Alignment.Bottom,
        horizontalArrangement = Arrangement.End
    ) {
        if(!isRightLine) {
            Row(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight()
                    .padding(Config.defaultSpacerDp),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.Bottom
            ) {
                content()
            }
        }
        ImageView(
            modifier = modifier
                .fillMaxWidth(fraction = .8f),
            image = image,
            animated = animated,
            aspectRatio = aspectRatio,
            contentScale = contentScale,
            colorFilter = colorFilter
        )
        if(isRightLine) {
            Row(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight()
                    .padding(Config.defaultSpacerDp),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.Bottom
            ) {
                content()
            }
        }
    }
}

@Composable
fun WalkingImage(
    modifier: Modifier = Modifier,
    image: ImageOpt,
    aspectRatio: Float? = null,
    contentScale: ContentScale = ContentScale.Fit,
    colorFilter: ColorFilter? = null
) {
    val animateFloat = remember { Animatable(0f) }
    val scope = rememberCoroutineScope()
    val angle = remember { 10f }
    val points = remember { listOf(.16f, .5f, .83f, 1f) }

    ImageView(
        modifier = modifier
            .onFirstVisible(minFractionVisible = Config.FRACTION_VISIBLE_THRESHOLD) {
                scope.launch {
                    points.forEach {point ->
                        animateFloat.animateTo(
                            targetValue = point,
                            animationSpec = tween(
                                durationMillis = 250,
                                delayMillis = 250
                            )
                        )
                    }
                }
            }
            .graphicsLayer {
                scaleX = animateFloat.value
                scaleY = animateFloat.value
                animateFloat.value.let { anim ->
                    rotationZ = sin(3 * PI.toFloat() * anim) * angle
                }
            },
        image = image,
        animated = false,
        aspectRatio = aspectRatio,
        contentScale = contentScale,
        colorFilter = colorFilter
    )
}

@Composable
fun EmoeImage(
    modifier: Modifier = Modifier,
    image: ImageOpt,
    aspectRatio: Float? = null,
    contentScale: ContentScale = ContentScale.Fit,
    colorFilter: ColorFilter? = null
) {
    val scope = rememberCoroutineScope()
    val animateFloat = remember { Animatable(-50f) }
    val emoeList = remember { listOf("емое", "емоё", "ёмое", "ёмоё") }

    Box(
        modifier = Modifier
            .wrapContentHeight(),
        contentAlignment = Alignment.Center
    ) {
        ImageView(
            modifier = modifier
                .onFirstVisible(minFractionVisible = Config.FRACTION_VISIBLE_THRESHOLD) {
                    scope.launch {
                        animateFloat.animateTo(
                            targetValue = 300f,
                            animationSpec = infiniteRepeatable(
                                animation = tween(5000),
                                repeatMode = RepeatMode.Reverse
                            )
                        )
                    }
                },
            image = image,
            animated = false,
            aspectRatio = aspectRatio,
            contentScale = contentScale,
            colorFilter = colorFilter
        )

        Column {
            emoeList.forEach { emoe ->
                Text(
                    modifier = Modifier
                        .graphicsLayer {
                            translationX = animateFloat.value
                        },
                    text = emoe,
                    fontFamily = rubikMonoOne
                )
            }
        }
    }
}
