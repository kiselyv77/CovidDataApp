package com.example.coviddataapp.presentation.country_detail.components

import androidx.compose.animation.core.*
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun InfoBlock(modifier: Modifier, title:String, text:String,  borderColor:Color){
    val translateAnim  by animateFloatAsState(
        targetValue = 1000f,
        animationSpec = infiniteRepeatable(
            tween(durationMillis = 1200, delayMillis = 0, easing = LinearOutSlowInEasing),
        )
    )

    val background = Brush.linearGradient(
        colors = listOf(
            borderColor.copy(alpha = 0.2f),
            borderColor.copy(alpha = 0.1f),
            borderColor.copy(alpha = 0.2f),
        ),
        start = Offset(10f, 10f),
        end = Offset(translateAnim, translateAnim)
    )

    Box(
        modifier = modifier
            .border(
                width = 2.dp,
                color = borderColor,
                shape = RoundedCornerShape(40)
            ).background(background, shape = RoundedCornerShape(40)),
        contentAlignment = Alignment.TopCenter
    ){
        Column(
            modifier = Modifier
                .padding(10.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = title,
                fontSize = 18.sp
            )
            Text(
                text = text,
                fontSize = 15.sp,
                color = borderColor
            )
        }
    }
}

