package com.example.coviddataapp.data.remote.dto

data class BodyStatisticsListDto(
    val errors: List<Any>,
    val `get`: String,
    val parameters: Any,
    val response: List<CountryStatisticDto>,
    val results: Int
)
