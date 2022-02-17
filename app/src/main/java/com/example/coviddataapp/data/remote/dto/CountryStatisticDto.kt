package com.example.coviddataapp.data.remote.dto

import com.example.coviddataapp.damain.model.CountryStatistics

data class CountryStatisticDto(
    val cases: CasesDto = CasesDto(),
    val continent: String = "",
    val country: String = "",
    val day: String = "",
    val deaths: DeathsDto = DeathsDto(),
    val population: Int = 0,
    val tests: TestsDto = TestsDto(),
    val time: String = ""
){
    fun toCountryStatistics(): CountryStatistics  {
        return CountryStatistics(
            cases = cases.toCases(),
            continent = continent,
            country = country,
            day = day,
            deaths = deaths.toDeaths(),
            population = population,
            tests = tests.toTests(),
            time = time
        )
    }

}
