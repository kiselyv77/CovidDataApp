package com.example.coviddataapp.presentation.coutries.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.Text

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun CountryItem(text:String){
    Box(Modifier.fillMaxWidth().wrapContentHeight().padding(20.dp)){
        Text(text)
    }
}