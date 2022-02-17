package com.example.coviddataapp.damain.repository

import com.example.coviddataapp.data.remote.dto.BodyCountriesListDto
import com.example.coviddataapp.data.remote.dto.BodyStatisticsListDto
import retrofit2.http.Query

interface CovidRepository {
    suspend fun getCountries(): BodyCountriesListDto
    suspend fun getStatisticByContry(countryName:String): BodyStatisticsListDto
    suspend fun getStatisticList(countryName:String, day:String): BodyStatisticsListDto

}