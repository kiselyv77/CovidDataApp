package com.example.coviddataapp.damain.use_cases.get_countries

import com.example.coviddataapp.common.Resource
import com.example.coviddataapp.damain.repository.CovidRepository
import com.example.coviddataapp.data.remote.dto.BodyCountriesListDto
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoutriesUseCase @Inject constructor(
    private val repository: CovidRepository
)  {

    operator fun invoke(searchText: String): Flow<Resource<List<String>>> = flow{
        try{
            emit(Resource.Loading<List<String>>())
            val coutries = repository.getCountries().response.filter{
                it.lowercase().contains(searchText.lowercase())
            }
            emit(Resource.Success<List<String>>(data = coutries))
        } catch (e: HttpException){
            emit(Resource.Error<List<String>>(e.localizedMessage?: "unexpected error"))
        }catch (e: IOException){
            emit(Resource.Error<List<String>>(e.localizedMessage?: "not enternet"))
        }

    }


}