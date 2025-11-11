package com.cvetyshayasiren.aiphotosession

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.cvetyshayasiren.aiphotosession.Config.defaultSpacerDp

object Config {
    val defaultRoundedShape = RoundedCornerShape(18.dp)
    val shadowElevation = 2.dp

    val defaultSpacerDp = 24.dp

    const val FRACTION_VISIBLE_THRESHOLD = 0.2f

    val loadingPhrases = listOf(
        "двигаю мосты", "подгружаю вайбец", "ща ща погоди", "накладываю нуар", "стираю границы воображения"
    )

    val almostLoadingPhrases = listOf(
        "вот вот", "почти всё", "ну вот и емое"
    )

    @Composable
    fun someSpacer(dp: Dp = defaultSpacerDp) = Spacer(modifier = Modifier.height(dp))

    @Composable
    fun smallSpacer() = someSpacer(dp = defaultSpacerDp)

    @Composable
    fun bigBigSpacer() = someSpacer(dp = defaultSpacerDp * 2)
}