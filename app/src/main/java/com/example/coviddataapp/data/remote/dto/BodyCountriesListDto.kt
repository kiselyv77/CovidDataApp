package com.example.coviddataapp.data.remote.dto

data class BodyCountriesListDto(
    val errors: List<Any>,
    val `get`: String,
    val parameters: List<Any>,
    val response: List<String>,
    val results: Int
)



