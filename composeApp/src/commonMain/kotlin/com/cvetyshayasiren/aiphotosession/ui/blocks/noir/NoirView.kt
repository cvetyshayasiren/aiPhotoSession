package com.cvetyshayasiren.aiphotosession.ui.blocks.noir

import androidx.compose.animation.core.*
import androidx.compose.foundation.background
import androidx.compose.foundation.basicMarquee
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import com.cvetyshayasiren.aiphotosession.Config
import com.cvetyshayasiren.aiphotosession.data.ImageOpt
import com.cvetyshayasiren.aiphotosession.ui.theme.rubikMonoOne
import com.cvetyshayasiren.aiphotosession.ui.utils.EmoeImage
import com.cvetyshayasiren.aiphotosession.ui.utils.ImageView
import com.cvetyshayasiren.aiphotosession.ui.utils.ImageViewCaptioned
import com.cvetyshayasiren.aiphotosession.ui.utils.ImageViewLabeled
import com.cvetyshayasiren.aiphotosession.ui.utils.ImageViewWithLine
import com.cvetyshayasiren.aiphotosession.ui.utils.VerticalText
import com.cvetyshayasiren.aiphotosession.ui.utils.WalkingImage
import com.cvetyshayasiren.aiphotosession.ui.utils.animated
import com.cvetyshayasiren.aiphotosession.ui.widgets.FourSquareView
import com.cvetyshayasiren.aiphotosession.ui.widgets.NamesWidget
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
        horizontalAlignment = Alignment.Start
    ) {
        Config.bigSpacer()
        Text(
            modifier = Modifier.basicMarquee(),
            text = " AI PHOTO SESSION",
            fontFamily = rubikMonoOne,
            fontSize = MaterialTheme.typography.displayMedium.fontSize,
            color = MaterialTheme.colorScheme.primary
        )
        Config.bigSpacer()
        ImageView(
            image = ImageOpt.PAIR_4
        )
        Config.smallSpacer()
        Text(
            modifier = Modifier
                .padding(12.dp)
                .graphicsLayer {
                    rotationZ = animateFloat.value
                },
            text = "Два нейро дундучка, знакомься",
            fontFamily = rubikMonoOne,
            fontSize = MaterialTheme.typography.bodyLarge.fontSize,
            color = MaterialTheme.colorScheme.secondary
        )

        ImageViewWithLine(
            image = ImageOpt.DUB_NOIR_2,
            isRightLine = true
        ) {
            VerticalText("ILYA")
        }

        ImageViewWithLine(
            modifier = Modifier
                .clip(
                    shape = RoundedCornerShape(bottomStart = Config.bigRound)
                )
                .shadow(
                    elevation = Config.shadowElevation,
                    shape = RoundedCornerShape(bottomStart = Config.bigRound)
                ),
            image = ImageOpt.VI_NOIR_9,
            isRightLine = false
        ) {
            VerticalText("VITALYA")
        }
        Config.smallSpacer()
        NamesWidget()
        Config.bigSpacer()

        ImageViewCaptioned(image = ImageOpt.DUB_NOIR_5) {
            Text(
                text = ImageOpt.DUB_NOIR_5.comment,
                fontFamily = rubikMonoOne,
                fontSize = MaterialTheme.typography.bodySmall.fontSize,
            )
        }

        Config.bigSpacer()
        Text(
            modifier = Modifier.padding(Config.bigPadding).fillMaxWidth(.8f),
            text = "Сидят они, стоят они и пырят, а там дальше ещё разлёгся, вобщ канеш, что позволяет себе? А? А?",
            fontFamily = rubikMonoOne,
            fontSize = MaterialTheme.typography.bodyLarge.fontSize,
            color = MaterialTheme.colorScheme.tertiary
        )

        ImageViewLabeled(
            image = ImageOpt.VI_NOIR_1
        ) {
            Text(
                text = ImageOpt.VI_NOIR_1.comment,
                fontFamily = rubikMonoOne,
                fontSize = MaterialTheme.typography.labelSmall.fontSize,
            )
        }


        ImageViewWithLine(
            modifier = Modifier
                .clip(
                    shape = RoundedCornerShape(bottomEnd = Config.bigRound)
                )
                .shadow(
                    elevation = Config.shadowElevation,
                    shape = RoundedCornerShape(bottomEnd = Config.bigRound)
                ),
            image = ImageOpt.DUB_NOIR_4,
            isRightLine = true
        ) {
            VerticalText(
                text = "rasSELSYA",
                color = MaterialTheme.colorScheme.tertiary
            )
        }

        Config.bigSpacer()
        Text(
            modifier = Modifier.basicMarquee(),
            text = "ILYA VITALYA ILYA VITALYA ILYA VITALYA ILYA VITALYA ILYA VITALYA ILYA VITALYA",
            fontFamily = rubikMonoOne,
            fontSize = MaterialTheme.typography.displayLarge.fontSize,
            color = MaterialTheme.colorScheme.primary
        )
        Config.bigSpacer()

        ImageViewLabeled(image = ImageOpt.PAIR_0) {
            Text(
                text = ImageOpt.PAIR_0.comment,
                fontFamily = rubikMonoOne,
                fontSize = MaterialTheme.typography.labelSmall.fontSize,
            )
        }

        FourSquareView(photo = ImageOpt.DUB_NOIR_3)

        Text(
            modifier = Modifier.padding(Config.bigPadding).animated(),
            text = "Тыж своими пальчатками на фото мож тыкать, рассмотреть если над",
            fontFamily = rubikMonoOne,
            fontStyle = FontStyle.Italic,
            fontSize = MaterialTheme.typography.labelSmall.fontSize,
            color = MaterialTheme.colorScheme.tertiaryFixedDim
        )

        ImageViewCaptioned(
            image = ImageOpt.DUB_NOIR_7
        ) {
            Text(
                modifier = Modifier.padding(Config.bigPadding),
                text = ImageOpt.DUB_NOIR_7.comment,
                fontFamily = rubikMonoOne,
                fontSize = MaterialTheme.typography.bodyLarge.fontSize,
                color = MaterialTheme.colorScheme.primary
            )
        }

        Config.bigSpacer()
        Text(
            modifier = Modifier.padding(Config.bigPadding).fillMaxWidth(.6f).align(Alignment.End),
            text = "А дальше вообще ор, идёт как машина, прям на нас идёт, поход пора сваливать",
            fontFamily = rubikMonoOne,
            fontSize = MaterialTheme.typography.bodyLarge.fontSize,
            color = MaterialTheme.colorScheme.tertiaryFixedDim
        )

        WalkingImage(image = ImageOpt.VI_NOIR_0)

        Config.bigSpacer()
        Text(
            modifier = Modifier.padding(Config.bigPadding),
            text = "Чую я ты хочешь ещё попырить на нейрочувачков, ну чтож мне не жалк совсем",
            fontFamily = rubikMonoOne,
            fontSize = MaterialTheme.typography.bodyLarge.fontSize,
            color = MaterialTheme.colorScheme.primary
        )
        ImageView(
            modifier = Modifier
                .graphicsLayer {
                    translationX = animateFloat.value * 2
                },
            image = ImageOpt.VI_NOIR_2
        )
        ImageView(image = ImageOpt.DUB_NOIR_1)
        ImageViewWithLine(
            image = ImageOpt.VI_NOIR_7,
            isRightLine = true
        ) {
            VerticalText(
                text = "ох",
                fontSize = MaterialTheme.typography.labelSmall.fontSize,
            )
        }
        ImageViewWithLine(
            image = ImageOpt.DUB_NOIR_6,
            isRightLine = false
        ) {
            VerticalText(
                text = "ах",
                fontSize = MaterialTheme.typography.labelSmall.fontSize,
            )
        }
        EmoeImage(image = ImageOpt.DUB_NOIR_0)
        ImageView(image = ImageOpt.VI_NOIR_5)
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(Config.smallSpacerDp * 6)
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(
                            MaterialTheme.colorScheme.surfaceVariant,
                            MaterialTheme.colorScheme.surface
                        )
                    )
                )
        )
    }
}