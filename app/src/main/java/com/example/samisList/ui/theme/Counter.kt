package com.example.littlelemon.ui.theme

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun VisibleCounterScreen(targetValue: Int) {
    val listState = rememberLazyListState()
    val isVisible = remember { mutableStateOf(false) }

    // Check the visibility of the counter item
    LaunchedEffect(listState) {
        listState.layoutInfo.visibleItemsInfo.forEach { itemInfo ->
            if (itemInfo.index == 0) {
                isVisible.value = true
            }
        }
    }

    LazyColumn(modifier = Modifier.fillMaxSize(), state = listState) {
        item {
            // Display the counter animation when the item is visible
            if (isVisible.value) {
                CounterAnimation(targetValue = targetValue)
            } else {
                // A Spacer is used here to create enough space for scrolling before the counter appears
                Spacer(modifier = Modifier.height(600.dp))
            }
        }
    }
}

@Composable
fun CounterAnimation(targetValue: Int) {
    // The animation logic for the counter
    val counter = remember { Animatable(0f) }
    LaunchedEffect(key1 = targetValue) {
        counter.animateTo(
            targetValue = targetValue.toFloat(),
            animationSpec = tween(durationMillis = 4000)
        )
    }

    // Displaying the animated counter value
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(
            text = counter.value.toInt().toString(),
            fontSize = 24.sp, // Set the text size here
            color = Color.Red // Set the text color here
        )
    }
}

