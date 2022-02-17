package com.example.coviddataapp.presentation.country_detail

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.coviddataapp.common.Resource
import com.example.coviddataapp.damain.use_cases.get_statistic_country.GetStatisticUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CountryDetailViewModel @Inject constructor(
    val getCountryUseCase: GetStatisticUseCase,
    savedStateHandle: SavedStateHandle
): ViewModel() {

    private val _state = mutableStateOf<StateCountryDetailScreen>(StateCountryDetailScreen())
    val state: State<StateCountryDetailScreen> = _state

    init{
        savedStateHandle.get<String>("countryName")?.let{
            getCoutries(it)
        }
    }

    private fun getCoutries(countryName:String){
        getCountryUseCase(countryName).onEach{result ->
            when (result){
                is Resource.Success -> {
                    _state.value = _state.value.copy(
                        coutry = result.data!!.response[0].toCountryStatistics(),
                        isLoading = false,
                        error = ""


                    )
                }
                is Resource.Error -> {
                    _state.value = _state.value.copy(error = result.message?:"unexpected error")
                }
                is Resource.Loading -> {
                    _state.value = _state.value.copy(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }

}