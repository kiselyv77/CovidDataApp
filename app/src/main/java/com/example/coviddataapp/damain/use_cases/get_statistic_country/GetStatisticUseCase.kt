package com.example.coviddataapp.damain.use_cases.get_statistic_country

import com.example.coviddataapp.common.Resource
import com.example.coviddataapp.damain.repository.CovidRepository
import com.example.coviddataapp.data.remote.dto.BodyCountriesListDto
import com.example.coviddataapp.data.remote.dto.BodyStatisticsListDto
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetStatisticUseCase @Inject constructor(
    private val repository: CovidRepository
)  {

    operator fun invoke(countryName:String): Flow<Resource<BodyStatisticsListDto>> = flow{
        try{
            emit(Resource.Loading<BodyStatisticsListDto>())
            val coutries = repository.getStatisticByContry(countryName)
            emit(Resource.Success<BodyStatisticsListDto>(data = coutries))
        } catch (e: HttpException){
            emit(Resource.Error<BodyStatisticsListDto>(e.localizedMessage?: "unexpected error"))
        }catch (e: IOException){
            emit(Resource.Error<BodyStatisticsListDto>(e.localizedMessage?: "not enternet"))
        }

    }


}