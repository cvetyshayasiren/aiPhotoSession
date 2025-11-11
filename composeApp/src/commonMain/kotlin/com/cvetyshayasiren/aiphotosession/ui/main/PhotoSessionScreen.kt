package com.cvetyshayasiren.aiphotosession.ui.main

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.cvetyshayasiren.aiphotosession.data.ImageOpt
import com.cvetyshayasiren.aiphotosession.ui.blocks.carousel.CarouselView
import com.cvetyshayasiren.aiphotosession.ui.blocks.cyber.CyberView
import com.cvetyshayasiren.aiphotosession.ui.blocks.noir.NoirView
import com.cvetyshayasiren.aiphotosession.ui.utils.ImageView

@Composable
fun PhotoSessionScreen(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.Start
    ) {
        NoirView(modifier = Modifier.background(MaterialTheme.colorScheme.surfaceVariant))
        CyberView()
        CarouselView(modifier = Modifier.background(MaterialTheme.colorScheme.surfaceVariant))
    }
}

//@Composable
//fun PhotoSessionScreenTest(
//    modifier: Modifier
//) {
//    Column(
//        modifier = modifier,
//        verticalArrangement = Arrangement.spacedBy(12.dp),
//        horizontalAlignment = Alignment.CenterHorizontally
//    ) {
//        ImageOpt.entries.forEach {
//            ImageView(
//                modifier = Modifier.fillMaxWidth(.8f),
//                image = it
//            )
//        }
//    }
//}