package com.cvetyshayasiren.aiphotosession.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.cvetyshayasiren.aiphotosession.Config

@Composable
fun MainScreenView(
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.spacedBy(
            space = Config.defaultSpacerDp
        )
    ) {
        NoirView(modifier = Modifier.background(MaterialTheme.colorScheme.surfaceVariant))
        CyberView()
        CarouselView(modifier = Modifier.background(MaterialTheme.colorScheme.tertiary))
    }
}