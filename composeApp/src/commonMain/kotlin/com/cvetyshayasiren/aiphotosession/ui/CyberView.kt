package com.cvetyshayasiren.aiphotosession.ui

import androidx.compose.foundation.basicMarquee
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.unit.dp
import com.cvetyshayasiren.aiphotosession.Config
import com.cvetyshayasiren.aiphotosession.data.ImageOpt
import com.cvetyshayasiren.aiphotosession.ui.theme.rubikMonoOne
import com.github.panpf.sketch.AsyncImage

@Composable
fun CyberView(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.spacedBy(
            space = Config.defaultSpacerDp
        )
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
                fontSize = MaterialTheme.typography.displaySmall.fontSize,
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

        Row {
            AsyncImage(
                modifier = Modifier
                    .weight(1f)
                    .clip(Config.defaultRoundedShape)
                    .shadow(elevation = Config.shadowElevation)
                    .aspectRatio(1f),
                uri = ImageOpt.DUB_CYBER_5.getUri(),
                contentDescription = "photo"
            )
            AsyncImage(
                modifier = Modifier
                    .weight(1f)
                    .clip(Config.defaultRoundedShape)
                    .shadow(elevation = Config.shadowElevation)
                    .aspectRatio(1f),
                uri = ImageOpt.VI_CYBER_1.getUri(),
                contentDescription = "photo"
            )
        }

        Text(
            modifier = Modifier.basicMarquee(),
            text = "CYBER ILYA CYBER VITALYA CYBER ILYA CYBER VITALYA CYBER ILYA CYBER VITALYA CYBER ILYA CYBER VITALYA",
            fontFamily = rubikMonoOne,
            fontSize = MaterialTheme.typography.displayLarge.fontSize,
            color = MaterialTheme.colorScheme.primary
        )

        Config.defaultSpacer()

        Text(
            modifier = Modifier.padding(12.dp),
            text = "Смри как машет руками то, мужицке",
            fontFamily = rubikMonoOne,
            fontSize = MaterialTheme.typography.bodyLarge.fontSize,
            color = MaterialTheme.colorScheme.primary
        )
        AsyncImage(
            modifier = Modifier
                .clip(Config.defaultRoundedShape)
                .shadow(elevation = Config.shadowElevation),
            uri = ImageOpt.DUB_CYBER_0.getUri(),
            contentDescription = "photo"
        )
        AsyncImage(
            modifier = Modifier
                .clip(Config.defaultRoundedShape)
                .shadow(elevation = Config.shadowElevation),
            uri = ImageOpt.DUB_CYBER_4.getUri(),
            contentDescription = "photo"
        )

        Config.defaultSpacer()
    }
}