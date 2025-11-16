package com.cvetyshayasiren.aiphotosession.ui.utils

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectTransformGestures
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Cancel
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.BasicAlertDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.onFirstVisible
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.toIntRect
import androidx.compose.ui.unit.toSize
import androidx.compose.ui.util.lerp
import androidx.compose.ui.window.DialogProperties
import com.cvetyshayasiren.aiphotosession.Config
import com.cvetyshayasiren.aiphotosession.data.ImageOpt
import com.cvetyshayasiren.aiphotosession.ui.main.MainViewModel
import com.cvetyshayasiren.aiphotosession.ui.theme.rubikMonoOne
import com.github.panpf.sketch.AsyncImage
import com.github.panpf.sketch.rememberAsyncImageState
import com.github.panpf.sketch.request.LoadState
import com.github.panpf.sketch.util.Size
import dev.chrisbanes.haze.hazeEffect
import dev.chrisbanes.haze.hazeSource
import dev.chrisbanes.haze.materials.ExperimentalHazeMaterialsApi
import dev.chrisbanes.haze.materials.HazeMaterials
import dev.chrisbanes.haze.rememberHazeState
import kotlinx.coroutines.launch
import me.saket.telephoto.zoomable.ZoomableContentLocation
import me.saket.telephoto.zoomable.rememberZoomableState
import me.saket.telephoto.zoomable.zoomable
import kotlin.math.PI
import kotlin.math.exp
import kotlin.math.sin

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ImageView(
    image: ImageOpt,
    modifier: Modifier = Modifier
        .fillMaxWidth()
        .animated()
        .shadow(Config.shadowElevation),
    useImageAspectRatio: Boolean = true,
    contentScale: ContentScale = ContentScale.Crop,
    colorFilter: ColorFilter? = null,
    separateDialogState: Boolean = false
) {
    val state = rememberAsyncImageState()
    val loadState: LoadState? = state.loadState
    val expandDialog = remember { mutableStateOf(false) }

    when (loadState) {
        is LoadState.Started -> { MainViewModel.addInLoadingQueue(image) }
        else -> { MainViewModel.onLoadingSuccess(image) }
    }

    AsyncImage(
        state = state,
        modifier = modifier
            .then(other = if(useImageAspectRatio) Modifier.aspectRatio(image.getRatio()) else Modifier)
            .clickable { expandDialog.value = !expandDialog.value },
        uri = image.getUri(),
        contentDescription = "photo",
        contentScale = contentScale,
        colorFilter = colorFilter
    )

    AnimatedVisibility(
        visible = expandDialog.value
    ) {
        BasicAlertDialog(
            modifier = Modifier.fillMaxSize().background(MaterialTheme.colorScheme.surface.copy(alpha = .8f)),
            onDismissRequest = { expandDialog.value = false },
            properties = DialogProperties(
                dismissOnBackPress = true,
                dismissOnClickOutside = true,
                usePlatformDefaultWidth = false
            )
        ) {
            AsyncImage(
                state = if(separateDialogState) rememberAsyncImageState() else state,
                modifier = modifier
                    .fillMaxSize()
                    .zoomable(
                        clipToBounds = false,
                        state = rememberZoomableState(),
                        onClick = { expandDialog.value = false }
                    ),
                uri = image.getUri(),
                contentDescription = "photo",
                contentScale = ContentScale.Fit
            )
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(Config.bigPadding),
                contentAlignment = Alignment.BottomEnd
            ) {
                Box(
                    modifier = Modifier
                        .clip(Config.smallRoundedShape)
                        .background(MaterialTheme.colorScheme.surfaceContainer)
                        .fillMaxWidth()
                        .wrapContentSize()
                        .padding(horizontal = Config.bigPadding, vertical = Config.smallSpacerDp)
                ) {
                    Text(
                        text = image.comment,
                        fontFamily = rubikMonoOne,
                        fontSize = MaterialTheme.typography.labelSmall.fontSize,
                        color = MaterialTheme.colorScheme.onSurface
                    )
                }
                IconButton(
                    modifier = Modifier.align(Alignment.TopEnd).padding(Config.smallPadding),
                    onClick = {
                        expandDialog.value = false
                    }
                ) {
                    Icon(
                        imageVector = Icons.Outlined.Cancel,
                        contentDescription = "close"
                    )
                }

            }
        }
    }
}

@OptIn(ExperimentalHazeMaterialsApi::class)
@Composable
fun ImageViewCaptioned(
    image: ImageOpt,
    modifier: Modifier = Modifier
        .fillMaxWidth(),
    useImageAspectRatio: Boolean = true,
    contentScale: ContentScale = ContentScale.Crop,
    colorFilter: ColorFilter? = null,
    separateDialogState: Boolean = false,
    content: @Composable (BoxScope.() -> Unit)
) {
    val hazeState = rememberHazeState()
    Box(
        modifier = Modifier
            .wrapContentSize()
            .animated()
            ,
        contentAlignment = Alignment.BottomStart
    ) {
        ImageView(
            modifier = modifier.hazeSource(hazeState),
            image = image,
            useImageAspectRatio = useImageAspectRatio,
            contentScale = contentScale,
            colorFilter = colorFilter,
            separateDialogState = separateDialogState
        )
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .hazeEffect(
                    state = hazeState,
                    style = HazeMaterials.thin()
                )
                .padding(Config.smallSpacerDp),
            contentAlignment = Alignment.CenterStart
        ) {
            content()
        }
    }
}

@OptIn(ExperimentalHazeMaterialsApi::class)
@Composable
fun ImageViewLabeled(
    image: ImageOpt,
    modifier: Modifier = Modifier.fillMaxWidth(),
    useImageAspectRatio: Boolean = true,
    contentScale: ContentScale = ContentScale.Crop,
    colorFilter: ColorFilter? = null,
    separateDialogState: Boolean = false,
    content: @Composable (BoxScope.() -> Unit)
) {
    val hazeState = rememberHazeState()
    Box(
        modifier = Modifier
            .wrapContentSize()
            .animated()
            .shadow(Config.shadowElevation),
        contentAlignment = Alignment.BottomEnd
    ) {
        ImageView(
            modifier = modifier.hazeSource(hazeState),
            image = image,
            useImageAspectRatio = useImageAspectRatio,
            contentScale = contentScale,
            colorFilter = colorFilter,
            separateDialogState = separateDialogState
        )
        Box(
            modifier = Modifier
                .padding(Config.smallPadding)
                .clip(Config.smallRoundedShape)
                .hazeEffect(state = hazeState, style = HazeMaterials.ultraThin())
                .padding(Config.smallPadding),
            contentAlignment = Alignment.Center
        ) {
            content()
        }
    }
}

@Composable
fun ImageViewWithLine(
    modifier: Modifier = Modifier
        .shadow(Config.shadowElevation),
    image: ImageOpt,
    useImageAspectRatio: Boolean = true,
    contentScale: ContentScale = ContentScale.Crop,
    colorFilter: ColorFilter? = null,
    separateDialogState: Boolean = false,
    isRightLine: Boolean = true,
    content: @Composable (RowScope.() -> Unit)
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .animated(),
        verticalAlignment = Alignment.Bottom,
        horizontalArrangement = Arrangement.End
    ) {
        if(!isRightLine) {
            Row(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight()
                    .padding(Config.smallSpacerDp),
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
            useImageAspectRatio = useImageAspectRatio,
            contentScale = contentScale,
            colorFilter = colorFilter,
            separateDialogState = separateDialogState
        )
        if(isRightLine) {
            Row(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight()
                    .padding(Config.smallSpacerDp),
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
    modifier: Modifier = Modifier
        .fillMaxWidth(),
    image: ImageOpt,
    useImageAspectRatio: Boolean = true,
    contentScale: ContentScale = ContentScale.Crop,
    colorFilter: ColorFilter? = null,
    separateDialogState: Boolean = false,
) {
    val animateFloat = remember { Animatable(0f) }
    val scope = rememberCoroutineScope()
    val angle = remember { 10f }
    val points = remember { listOf(.16f, .5f, .83f, 1f) }

    ImageView(
        modifier = modifier
            .onFirstVisible(minFractionVisible = .6f) {
                scope.launch {
                    points.forEach { point ->
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
                animateFloat.value.let { anim ->
                    scaleX = anim
                    scaleY = anim
                    rotationZ = sin(3 * PI.toFloat() * anim) * angle
                }
            }
            .shadow(Config.shadowElevation),
        image = image,
        useImageAspectRatio = useImageAspectRatio,
        contentScale = contentScale,
        colorFilter = colorFilter,
        separateDialogState = separateDialogState
    )
}

@Composable
fun EmoeImage(
    modifier: Modifier = Modifier
        .fillMaxWidth()
        .shadow(Config.shadowElevation),
    image: ImageOpt,
    useImageAspectRatio: Boolean = true,
    contentScale: ContentScale = ContentScale.Crop,
    colorFilter: ColorFilter? = null,
    separateDialogState: Boolean = false,
) {
    val emoeList = remember { listOf("емое", "емоё", "ёмое", "ёмоё") }
    val colors = listOf(
        MaterialTheme.colorScheme.primary, MaterialTheme.colorScheme.secondary,
        MaterialTheme.colorScheme.tertiary, MaterialTheme.colorScheme.secondaryFixed
    )

    Box(
        modifier = Modifier.wrapContentSize(),
        contentAlignment = Alignment.BottomStart
    ) {
        ImageView(
            modifier = modifier,
            image = image,
            useImageAspectRatio = useImageAspectRatio,
            contentScale = contentScale,
            colorFilter = colorFilter,
            separateDialogState = separateDialogState
        )

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(bottom = Config.smallPadding)
        ) {
            emoeList.forEachIndexed { index, emoe ->
                val animateFloat = remember { Animatable(0f) }

                LaunchedEffect(Unit) {
                    animateFloat.animateTo(
                        targetValue = 1f,
                        animationSpec = infiniteRepeatable(
                            animation = tween(
                                delayMillis = index * 250,
                                durationMillis = 5000
                            ),
                            repeatMode = RepeatMode.Reverse
                        )
                    )
                }

                Text(
                    modifier = Modifier
                        .graphicsLayer {
                            size.width.let { width ->
                                translationX = lerp(
                                    start = -width * 1.2f,
                                    stop = width * 2,
                                    fraction = (animateFloat.value)
                                )
                            }
                        },
                    text = emoe,
                    fontFamily = rubikMonoOne,
                    color = colors[index]
                )
            }
        }
    }
}
