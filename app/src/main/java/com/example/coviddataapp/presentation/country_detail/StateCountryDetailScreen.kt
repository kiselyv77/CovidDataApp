package com.example.coviddataapp.presentation.country_detail

import com.example.coviddataapp.damain.model.CountryStatistics

data class StateCountryDetailScreen (
    val isLoading: Boolean = false,
    val coutry: CountryStatistics = CountryStatistics(),
    val statisticList: List<CountryStatistics> = emptyList(),
    val error: String = ""
)



