package com.example.coviddataapp.presentation.coutries

data class StateCoutriesListScreen(
    val isLoading: Boolean = false,
    val coutries: List<String> = emptyList(),
    val error: String = ""
)
