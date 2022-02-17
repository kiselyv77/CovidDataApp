package com.example.coviddataapp.data.remote.dto

import com.example.coviddataapp.damain.model.Cases

data class CasesDto(
    val `1M_pop`: String = "",
    val active: Int = 0,
    val critical: Int = 0,
    val new: String = "",
    val recovered: Int = 0,
    val total: Int = 0
){
    fun toCases(): Cases {

        return Cases(
            active = this.active ,
            critical = this.critical,
            new = this.new?: "Нет данных",
            recovered = this.recovered,
            total = this.total
        )
    }

}



