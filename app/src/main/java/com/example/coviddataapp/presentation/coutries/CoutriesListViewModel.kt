package com.example.coviddataapp.presentation.coutries

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.coviddataapp.common.Resource
import com.example.coviddataapp.damain.use_cases.get_countries.GetCoutriesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject


@HiltViewModel
class CoutriesListViewModel @Inject constructor(
    val getCountriesUseCase: GetCoutriesUseCase,
    ): ViewModel(){

    private val _state = mutableStateOf<StateCoutriesListScreen>(StateCoutriesListScreen())
    val state: State<StateCoutriesListScreen> = _state

    init{
        getCoutries()
    }

    fun getCoutries(searchText: String = ""){
        getCountriesUseCase(searchText).onEach{result ->
            when (result){
                is Resource.Success -> {
                    _state.value = StateCoutriesListScreen(coutries = result.data!!)
                }
                is Resource.Error -> {
                    _state.value = StateCoutriesListScreen(error = result.message?:"unexpected error")
                }
                is Resource.Loading -> {
                    _state.value = StateCoutriesListScreen(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}