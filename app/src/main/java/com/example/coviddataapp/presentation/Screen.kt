package com.example.coviddataapp.presentation

sealed class Screen(val route: String) {
    object CountriesListScreen: Screen("countries_list_screen")
    object CountryDetailScreen: Screen("country_detail_screen")
}