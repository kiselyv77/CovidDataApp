package com.example.coviddataapp.data.remote.dto

import com.example.coviddataapp.damain.model.Deaths

data class DeathsDto(
    val `1M_pop`: String = "",
    val new: String = "",
    val total: Int = 0
){
    fun toDeaths():Deaths{
        return Deaths(
            new = new?:"Нет данных",
            total = total
        )
    }
}