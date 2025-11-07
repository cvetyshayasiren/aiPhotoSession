package com.cvetyshayasiren.aiphotosession.ui

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.*
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.basicMarquee
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.unit.dp
import com.cvetyshayasiren.aiphotosession.Config
import com.cvetyshayasiren.aiphotosession.data.ImageOpt
import com.cvetyshayasiren.aiphotosession.ui.theme.rubikMonoOne
import com.cvetyshayasiren.aiphotosession.ui.utils.ImageView
import com.cvetyshayasiren.aiphotosession.ui.utils.animated
import com.github.panpf.sketch.AsyncImage
import com.github.panpf.sketch.PainterState
import com.github.panpf.sketch.SubcomposeAsyncImage
import org.jetbrains.compose.resources.InternalResourceApi

@OptIn(InternalResourceApi::class)
@Composable
fun NoirView(modifier: Modifier = Modifier) {
    val animateFloat = remember { Animatable(-4f) }

    LaunchedEffect(Unit) {
        animateFloat.animateTo(
            targetValue = 4f,
            animationSpec = infiniteRepeatable(
                animation = tween(durationMillis = 500, easing = FastOutLinearInEasing),
                repeatMode = RepeatMode.Reverse
            )
        )
    }

    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(
            space = Config.defaultSpacerDp
        )
    ) {
        Text(
            modifier = Modifier.basicMarquee().padding(12.dp),
            text = "AI PHOTO SESSION",
            fontFamily = rubikMonoOne,
            fontSize = MaterialTheme.typography.displayMedium.fontSize,
            color = MaterialTheme.colorScheme.primary
        )

        NamesView()
        Config.defaultSpacer()
        FourSquareView(modifier = Modifier.fillMaxSize(.6f))
        Config.defaultSpacer()
        ShapesView()

        AsyncImage(
            modifier = Modifier
                .shadow(elevation = Config.shadowElevation)
                .animateContentSize()
                .aspectRatio(ImageOpt.DUB_NOIR_1.getRatio())
            ,
            uri = ImageOpt.DUB_NOIR_1.getUri(),
            contentDescription = "photo"
        )

        Config.defaultSpacer()
        Text(
            modifier = Modifier
                .padding(12.dp)
                .graphicsLayer {
                    rotationZ = animateFloat.value
                },
            text = "Два нейро дундуцке, вот они, смри:",
            fontFamily = rubikMonoOne,
            fontSize = MaterialTheme.typography.bodyLarge.fontSize,
            color = MaterialTheme.colorScheme.secondary
        )

        FlowRow {
            AsyncImage(
                modifier = Modifier
                    .animated()
                    .shadow(elevation = Config.shadowElevation),
                uri = ImageOpt.DUB_NOIR_2.getUri(),
                contentDescription = "photo"
            )
            AsyncImage(
                modifier = Modifier
                    .animated()
                    .shadow(elevation = Config.shadowElevation),
                uri = ImageOpt.VI_NOIR_9.getUri(),
                contentDescription = "photo"
            )
            AsyncImage(
                modifier = Modifier
                    .shadow(elevation = Config.shadowElevation),
                uri = ImageOpt.DUB_NOIR_5.getUri(),
                contentDescription = "photo"
            )
            Text(
                modifier = Modifier.padding(12.dp).width(200.dp),
                text = "Сидят, стоят и пырят, а там дальше ещё разлёгся, ваще капец, что позволяет себе? А? А?",
                maxLines = 10,
                fontFamily = rubikMonoOne,
                fontSize = MaterialTheme.typography.bodyLarge.fontSize,
                color = MaterialTheme.colorScheme.tertiary
            )
            AsyncImage(
                modifier = Modifier
                    .clip(Config.defaultRoundedShape)
                    .shadow(elevation = Config.shadowElevation),
                uri = ImageOpt.VI_NOIR_1.getUri(),
                contentDescription = "photo"
            )
        }

        Text(
            modifier = Modifier.basicMarquee(),
            text = "ILYA VITALYA ILYA VITALYA ILYA VITALYA ILYA VITALYA ILYA VITALYA ILYA VITALYA",
            fontFamily = rubikMonoOne,
            fontSize = MaterialTheme.typography.displayLarge.fontSize,
            color = MaterialTheme.colorScheme.primary
        )

        Config.defaultSpacer()
        Text(
            modifier = Modifier.padding(12.dp),
            text = "Смри ещё, этот паря уселся на мосту будто король тут он главный самый",
            fontFamily = rubikMonoOne,
            fontSize = MaterialTheme.typography.bodyLarge.fontSize,
            color = MaterialTheme.colorScheme.primary
        )
        AsyncImage(
            modifier = Modifier
                .clip(Config.defaultRoundedShape)
                .shadow(elevation = Config.shadowElevation),
            uri = ImageOpt.DUB_NOIR_7.getUri(),
            contentDescription = "photo"
        )
        Config.defaultSpacer()
        Text(
            modifier = Modifier.padding(12.dp),
            text = "А вот тут вообще ор, идёт как машина, прям на нас идёт, поход пора сваливать",
            fontFamily = rubikMonoOne,
            fontSize = MaterialTheme.typography.bodyLarge.fontSize,
            color = MaterialTheme.colorScheme.primary
        )
        AsyncImage(
            modifier = Modifier
                .clip(Config.defaultRoundedShape)
                .shadow(elevation = Config.shadowElevation),
            uri = ImageOpt.VI_NOIR_0.getUri(),
            contentDescription = "photo"
        )
        Config.defaultSpacer()

        Text(
            modifier = Modifier.padding(12.dp),
            text = "Чую я ты хочешь ещё попырить на нейрочувачков, ну чтож мне не жалк совсем",
            fontFamily = rubikMonoOne,
            fontSize = MaterialTheme.typography.bodyLarge.fontSize,
            color = MaterialTheme.colorScheme.primary
        )
        FlowRow {
            AsyncImage(
                modifier = Modifier
                    .graphicsLayer {
                        translationX = animateFloat.value * 2
                        clip = false
                    }
                    .clip(Config.defaultRoundedShape)
                    .shadow(elevation = Config.shadowElevation),
                uri = ImageOpt.VI_NOIR_2.getUri(),
                contentDescription = "photo"
            )
            AsyncImage(
                modifier = Modifier
                    .clip(Config.defaultRoundedShape)
                    .shadow(elevation = Config.shadowElevation),
                uri = ImageOpt.DUB_NOIR_6.getUri(),
                contentDescription = "photo"
            )
            AsyncImage(
                modifier = Modifier
                    .clip(Config.defaultRoundedShape)
                    .shadow(elevation = Config.shadowElevation),
                uri = ImageOpt.VI_NOIR_6.getUri(),
                contentDescription = "photo"
            )
            AsyncImage(
                modifier = Modifier
                    .clip(Config.defaultRoundedShape)
                    .shadow(elevation = Config.shadowElevation),
                uri = ImageOpt.DUB_NOIR_9.getUri(),
                contentDescription = "photo"
            )
            AsyncImage(
                modifier = Modifier
                    .clip(Config.defaultRoundedShape)
                    .shadow(elevation = Config.shadowElevation),
                uri = ImageOpt.VI_NOIR_7.getUri(),
                contentDescription = "photo"
            )
        }
        Config.defaultSpacer()
    }
}