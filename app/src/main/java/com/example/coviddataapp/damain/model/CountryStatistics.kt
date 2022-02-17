package com.example.coviddataapp.damain.model

import com.example.coviddataapp.data.remote.dto.CasesDto
import com.example.coviddataapp.data.remote.dto.DeathsDto
import com.example.coviddataapp.data.remote.dto.TestsDto

data class CountryStatistics(
    val cases: Cases = Cases(),
    val continent: String = "",
    val country: String = "",
    val day: String = "",
    val deaths: Deaths = Deaths(),
    val population: Int = 0,
    val tests: Tests = Tests(),
    val time: String = ""
)
