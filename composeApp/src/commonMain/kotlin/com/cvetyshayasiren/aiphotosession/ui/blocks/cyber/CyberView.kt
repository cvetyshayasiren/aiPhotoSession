package com.cvetyshayasiren.aiphotosession.ui.blocks.cyber

import androidx.compose.foundation.MarqueeAnimationMode
import androidx.compose.foundation.background
import androidx.compose.foundation.basicMarquee
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.cvetyshayasiren.aiphotosession.Config
import com.cvetyshayasiren.aiphotosession.data.ImageOpt
import com.cvetyshayasiren.aiphotosession.ui.theme.rubikMonoOne
import com.cvetyshayasiren.aiphotosession.ui.utils.ImageView
import com.cvetyshayasiren.aiphotosession.ui.utils.ImageViewLabeled
import com.cvetyshayasiren.aiphotosession.ui.utils.ImageViewWithLine
import com.cvetyshayasiren.aiphotosession.ui.utils.VerticalText
import com.cvetyshayasiren.aiphotosession.ui.widgets.ShapesWidget

@Composable
fun CyberView(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.Start,
    ) {
        Row(
            modifier = Modifier.padding(12.dp),
            verticalAlignment = Alignment.Bottom
        ) {
            Text(
                text = "CY",
                fontFamily = rubikMonoOne,
                fontSize = MaterialTheme.typography.displayMedium.fontSize,
                color = MaterialTheme.colorScheme.tertiary
            )
            Text(
                text = "BER",
                fontFamily = rubikMonoOne,
                fontSize = MaterialTheme.typography.displayMedium.fontSize,
                color = MaterialTheme.colorScheme.secondaryFixed
            )
        }

        Text(
            modifier = Modifier.padding(12.dp),
            text = "Тут я хз как, но они вдруг стали кибернетическе собаке будт",
            fontFamily = rubikMonoOne,
            fontSize = MaterialTheme.typography.bodyLarge.fontSize,
            color = MaterialTheme.colorScheme.primary
        )

        Row(
            modifier = Modifier.fillMaxWidth()
        ) {
            ImageView(
                modifier = Modifier.weight(1f),
                image = ImageOpt.DUB_CYBER_5
            )
            ImageView(
                modifier = Modifier.weight(1f),
                image = ImageOpt.VI_CYBER_1
            )
        }

        Text(
            modifier = Modifier.basicMarquee(),
            text = "CYBER ILYA CYBER VITALYA CYBER ILYA CYBER VITALYA CYBER ILYA CYBER VITALYA CYBER ILYA CYBER VITALYA",
            fontFamily = rubikMonoOne,
            lineHeight = 0.sp,
            fontSize = MaterialTheme.typography.displaySmall.fontSize,
            color = MaterialTheme.colorScheme.primary
        )

        Text(
            modifier = Modifier.basicMarquee(),
            textAlign = TextAlign.Start,
            text = "VITALYA CYBER ILYA CYBER VITALYA CYBER ILYA CYBER VITALYA CYBER ILYA CYBER VITALYA CYBER ILYA CYBER",
            fontFamily = rubikMonoOne,
            lineHeight = 0.sp,
            fontSize = MaterialTheme.typography.displaySmall.fontSize,
            color = MaterialTheme.colorScheme.primary
        )

        ImageViewLabeled(
            image = ImageOpt.DUB_CYBER_0
        ) {
            Text(
                text = "Смри как машет руками то, мужицке",
                fontFamily = rubikMonoOne,
                fontSize = MaterialTheme.typography.labelSmall.fontSize,
                color = MaterialTheme.colorScheme.primary
            )
        }

        ShapesWidget(
            photos = listOf(
                ImageOpt.VI_CYBER_3, ImageOpt.DUB_CYBER_1,
                ImageOpt.VI_CYBER_2, ImageOpt.DUB_CYBER_3,

            )
        )

        ImageViewWithLine(
            image = ImageOpt.DUB_CYBER_4,
        ) {
            VerticalText(
                text = "емоё",
                fontSize = MaterialTheme.typography.labelSmall.fontSize,
                color = MaterialTheme.colorScheme.primary
            )
        }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(Config.defaultSpacerDp * 6)
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(
                            MaterialTheme.colorScheme.surface,
                            MaterialTheme.colorScheme.surfaceVariant
                        )
                    )
                )
        )
    }
}