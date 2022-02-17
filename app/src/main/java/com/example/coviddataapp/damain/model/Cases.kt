package com.example.coviddataapp.damain.model

data class Cases(
    val active: Int = 0,
    val critical: Int = 0,
    val new: String = "",
    val recovered: Int = 0,
    val total: Int = 0
)
