package com.example.coviddataapp.data.remote

import com.example.coviddataapp.data.remote.dto.BodyCountriesListDto
import com.example.coviddataapp.data.remote.dto.BodyStatisticsListDto
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


interface CovidApi {
    @GET("/countries")
    suspend fun getCountries(): BodyCountriesListDto

    @GET("/statistics")
    suspend fun getStatisticByContry(@Query("country") countryName:String): BodyStatisticsListDto

    @GET("/history")
    suspend fun getStatisticList(@Query("country") countryName:String, @Query("day") day:String): BodyStatisticsListDto
}