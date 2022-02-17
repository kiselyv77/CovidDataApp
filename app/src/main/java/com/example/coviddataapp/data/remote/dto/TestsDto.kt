package com.example.coviddataapp.data.remote.dto

import com.example.coviddataapp.damain.model.Tests

data class TestsDto(
    val `1M_pop`: String = "",
    val total: Int = 0
){
    fun toTests(): Tests {
        return Tests(
            total = total
        )
    }
}