package com.example.coviddataapp.presentation.coutries

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.SemanticsProperties.ImeAction
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.coviddataapp.common.presentation.SearchBar
import com.example.coviddataapp.common.presentation.SearchState
import com.example.coviddataapp.common.presentation.rememberSearchState
import com.example.coviddataapp.presentation.Screen
import com.example.coviddataapp.presentation.coutries.components.CountryItem

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun CountriesListScreen(
    navController: NavController,
    viewModel: CoutriesListViewModel = hiltViewModel(),
    searchState: SearchState<String, String> = rememberSearchState()

) {
    val state = viewModel.state.value
    searchState.suggestions = state.coutries

    Scaffold(topBar = {
        SearchBar(
            query = searchState.query,
            onQueryChange = { searchState.query = it
                viewModel.getCoutries(it.text)},
            onSearchFocusChange = { searchState.focused = it },
            onClearQuery = { searchState.query = TextFieldValue("")
                viewModel.getCoutries()},
            onBack = { searchState.query = TextFieldValue("") },
            searching = searchState.searching,
            focused = searchState.focused,
            modifier = Modifier
        )
    }) {
        searchState.query

        Box(modifier = Modifier.fillMaxSize()) {
            LazyColumn(modifier = Modifier.fillMaxSize()) {
                items(state.coutries) {  coutry->
                    Box(modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight()
                        .clickable { navController.navigate(Screen.CountryDetailScreen.route + "/${coutry}") }
                    ){
                        Text(modifier = Modifier.padding(20.dp), text = coutry)
                    }
                }
            }
            if(state.error.isNotBlank()) {
                Text(
                    text = state.error,
                    color = MaterialTheme.colors.error,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp)
                        .align(Alignment.Center)
                )
            }
            if(state.isLoading) {
                CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
            }
        }
    }
}

