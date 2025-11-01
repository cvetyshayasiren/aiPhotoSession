package com.cvetyshayasiren.aiphotosession

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

object Config {
    val defaultRoundedShape = RoundedCornerShape(18.dp)
    val shadowElevation = 2.dp

    val defaultSpacerDp = 24.dp

    @Composable
    fun defaultSpacer(dp: Dp = defaultSpacerDp) = Spacer(modifier = Modifier.height(dp))
}