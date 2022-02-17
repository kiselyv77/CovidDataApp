package com.example.coviddataapp.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.coviddataapp.presentation.country_detail.CountryDetailScreen
import com.example.coviddataapp.presentation.coutries.CountriesListScreen
import com.example.coviddataapp.presentation.ui.theme.CovidDataAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CovidDataAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = Screen.CountriesListScreen.route
                    ) {
                        composable(
                            route = Screen.CountriesListScreen.route
                        ) {
                            CountriesListScreen(navController)
                        }
                        composable(
                            route = Screen.CountryDetailScreen.route + "/{countryName}"
                        ) {
                            CountryDetailScreen(navController)
                        }
                    }
                }
            }
        }
    }
}
