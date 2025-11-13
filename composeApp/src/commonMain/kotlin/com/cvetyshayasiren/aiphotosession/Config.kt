package com.cvetyshayasiren.aiphotosession

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

object Config {
    val minContentWidth = 200.dp
    val maxContentWidth = 840.dp

    val smallRound = 8.dp
    val bigRound = 24.dp

    val smallRoundedShape = RoundedCornerShape(smallRound)
    val bigRoundedShape = RoundedCornerShape(bigRound)

    val smallPadding = 4.dp
    val shadowElevation = 2.dp

    val smallSpacerDp = 24.dp

    const val FRACTION_VISIBLE_THRESHOLD = 0.2f

    val loadingPhrases = listOf(
        "двигаю мосты", "подгружаю вайбец", "ща ща погоди", "накладываю нуар", "стираю границы воображения", "потерпи емое"
    )

    val almostLoadingPhrases = listOf(
        "вот вот", "почти всё", "ну вот и емое"
    )

    @Composable
    fun someSpacer(dp: Dp = smallSpacerDp) = Spacer(modifier = Modifier.height(dp))

    @Composable
    fun smallSpacer() = someSpacer(dp = smallSpacerDp)

    @Composable
    fun bigSpacer() = someSpacer(dp = smallSpacerDp * 2)
}