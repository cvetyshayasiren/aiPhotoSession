package com.cvetyshayasiren.aiphotosession.ui.blocks.carousel

import androidx.compose.animation.AnimatedContent
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectHorizontalDragGestures
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.carousel.CarouselState
import androidx.compose.material3.carousel.HorizontalCenteredHeroCarousel
import androidx.compose.material3.carousel.rememberCarouselState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.cvetyshayasiren.aiphotosession.Config
import com.cvetyshayasiren.aiphotosession.data.ImageOpt
import com.cvetyshayasiren.aiphotosession.ui.theme.rubikMonoOne
import com.cvetyshayasiren.aiphotosession.ui.utils.ImageView
import com.cvetyshayasiren.aiphotosession.ui.utils.brutalShadow
import com.github.panpf.sketch.AsyncImage
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CarouselView(
    modifier: Modifier = Modifier,
    scope: CoroutineScope = rememberCoroutineScope()
) {
    val trashList = remember { ImageOpt.getShuffledTrashList() }
    val carouselState = rememberCarouselState(itemCount = {trashList.size})

    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(
            space = Config.smallSpacerDp
        )
    ) {
        Config.smallSpacer()
        Text(
            modifier = Modifier.padding(Config.bigPadding),
            text = "И на последок ещё кучка тебе в дорожку попырить паря",
            fontFamily = rubikMonoOne,
            fontSize = MaterialTheme.typography.bodyLarge.fontSize,
            color = MaterialTheme.colorScheme.primary
        )
        Config.smallSpacer()

        HorizontalCenteredHeroCarousel(
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(1.5f)
//                .pointerInput(Unit) {
//                    detectHorizontalDragGestures { _, dragAmount ->
//                        val isForward = dragAmount <= 0
//                        val pageToScroll = if(isForward) 1 else -1
//                        scope.launch {
//                            carouselState.animateScrollToItem(carouselState.currentItem + pageToScroll)
//                        }
//                    }
//                }
            ,
            state = carouselState
        ) {listIndex ->
            Box(
                modifier = Modifier.maskClip(Config.bigRoundedShape)
            ) {
                ImageView(
                    image = trashList[listIndex],
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.Crop,
                    useImageAspectRatio = false
                )
            }
        }

        AnimatedContent(
            modifier = Modifier
                .fillMaxWidth()
                .height(96.dp)
                .padding(Config.smallPadding)
                .brutalShadow()
                .background(MaterialTheme.colorScheme.surfaceContainer)
                .verticalScroll(rememberScrollState()),
            contentAlignment = Alignment.Center,
            targetState = carouselState.currentItem
        ) {item ->
            Text(
                modifier = Modifier
                    .padding(Config.bigPadding)
                ,
                text = trashList[item].comment,
                fontFamily = rubikMonoOne,
                fontSize = MaterialTheme.typography.bodySmall.fontSize,
                color = MaterialTheme.colorScheme.tertiary
            )
        }

        Row(
            Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement
                .spacedBy(
                    space = Config.smallPadding,
                    alignment = Alignment.CenterHorizontally
                )
        ) {
            IconButton(
                onClick = {
                    scope.launch { carouselState.animateScrollToPreviousPage() }
                }
            ) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.KeyboardArrowLeft,
                    contentDescription = "previous image"
                )
            }
            IconButton(
                onClick = {
                    scope.launch { carouselState.animateScrollToNextPage() }
                }
            ) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                    contentDescription = "next image"
                )
            }
        }

        HorizontalDivider()
        Config.smallSpacer()
    }
}

@OptIn(ExperimentalMaterial3Api::class)
suspend fun CarouselState.animateScrollToNextPage() =
    animateScrollToItem(currentItem + 1)

@OptIn(ExperimentalMaterial3Api::class)
suspend fun CarouselState.animateScrollToPreviousPage() =
    animateScrollToItem((currentItem - 1).coerceAtLeast(0))