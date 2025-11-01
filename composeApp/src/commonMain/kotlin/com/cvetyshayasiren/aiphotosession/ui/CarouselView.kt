package com.cvetyshayasiren.aiphotosession.ui

import androidx.compose.foundation.gestures.detectHorizontalDragGestures
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.carousel.HorizontalCenteredHeroCarousel
import androidx.compose.material3.carousel.rememberCarouselState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.cvetyshayasiren.aiphotosession.Config
import com.cvetyshayasiren.aiphotosession.data.ImageUris
import com.cvetyshayasiren.aiphotosession.ui.theme.rubikMonoOne
import com.github.panpf.sketch.AsyncImage
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CarouselView(
    modifier: Modifier = Modifier,
    scope: CoroutineScope = rememberCoroutineScope()
) {
    val trashList = remember { ImageUris.getShuffledTrashList() }
    val carouselState = rememberCarouselState(itemCount = {trashList.size})

    Config.defaultSpacer()
    Text(
        modifier = Modifier.padding(12.dp),
        text = "И на последок ещё кучка тебе в дорожку попырить паря",
        fontFamily = rubikMonoOne,
        fontSize = MaterialTheme.typography.bodyLarge.fontSize,
        color = MaterialTheme.colorScheme.primary
    )

    HorizontalCenteredHeroCarousel(
        modifier = Modifier
            .fillMaxWidth()
            .aspectRatio(1.5f)
            .pointerInput(Unit) {
                detectHorizontalDragGestures { _, dragAmount ->
                    val isForward = dragAmount <= 0
                    val pageToScroll = if(isForward) 1 else -1
                    scope.launch {
                        carouselState.animateScrollToItem(carouselState.currentItem + pageToScroll)
                    }
                }
            }
        ,
        state = carouselState,
    ) {listIndex ->
        AsyncImage(
            modifier = Modifier
                .fillMaxSize()
                .maskClip(Config.defaultRoundedShape),
            uri = trashList[listIndex].getUri(),
            contentScale = ContentScale.Crop,
            contentDescription = ""
        )
    }
}