package com.example.coviddataapp.data.repository

import com.example.coviddataapp.damain.repository.CovidRepository
import com.example.coviddataapp.data.remote.CovidApi
import com.example.coviddataapp.data.remote.dto.BodyCountriesListDto
import com.example.coviddataapp.data.remote.dto.BodyStatisticsListDto
import javax.inject.Inject

class CovidRepositoryImpl @Inject constructor(
    val api: CovidApi
): CovidRepository {
    override suspend fun getCountries(): BodyCountriesListDto {
        return api.getCountries()
    }

    override suspend fun getStatisticByContry(countryName:String): BodyStatisticsListDto {
        return api.getStatisticByContry(countryName)
    }

    override suspend fun getStatisticList(countryName: String, day: String): BodyStatisticsListDto {
        return api.getStatisticList(countryName, day)
    }
}