package com.example.coviddataapp.presentation.country_detail

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.coviddataapp.presentation.country_detail.components.InfoBlock
import com.example.coviddataapp.presentation.ui.theme.primaryLight
import com.example.coviddataapp.presentation.ui.theme.secondaryLight

@Composable
fun CountryDetailScreen(
    navController: NavController,
    viewModel: CountryDetailViewModel = hiltViewModel(),


    ){
    val state = viewModel.state.value
    Box(Modifier.fillMaxSize()){
        Scaffold(topBar = { TopAppBar(
            contentColor = Color.Black,
            backgroundColor = secondaryLight,
            title = { Text(state.coutry.country)},
            elevation = 0.dp,
            navigationIcon = { IconButton(onClick = { navController.popBackStack() }) {
                Icon(imageVector = Icons.Default.ArrowBack, contentDescription = null)

            }}
        ) } ) {
            Box(
                Modifier
                    .fillMaxSize()
                    .padding(10.dp)
                    .border(
                        width = 2.dp,
                        color = primaryLight,
                        shape = RoundedCornerShape(6)
                    )
            ){
                Column(){
                    Box(modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp))
                    {
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally

                        ){
                            Text(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(top = 10.dp),
                                text = state.coutry.country,
                                textAlign = TextAlign.Center,
                                fontSize = 35.sp
                            )
                            Text(
                                modifier = Modifier
                                    .fillMaxWidth(),
                                text = "Население: ${state.coutry.population} человек.",
                                textAlign = TextAlign.Center,
                                fontSize = 20.sp
                            )

                        }

                    }
                    Text(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(),
                        text = "За все время",
                        textAlign = TextAlign.Center,
                        fontSize = 35.sp
                    )
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 16.dp, bottom = 16.dp),
                        horizontalArrangement = Arrangement.SpaceEvenly
                    ){
                        InfoBlock(
                            modifier = Modifier.wrapContentSize(),
                            title = "Заражений",
                            text = state.coutry.cases.total.toString(),
                            borderColor = Color(227,38,54)
                        )
                        InfoBlock(
                            modifier = Modifier.wrapContentSize(),
                            title = "Выздоровело",
                            text = state.coutry.cases.recovered.toString() ,
                            borderColor = Color(68,148,74)
                        )
                        InfoBlock(
                            modifier = Modifier.wrapContentSize(),
                            title = "Смертей",
                            text = state.coutry.deaths.total.toString(),
                            borderColor = Color(28,28,28)
                        )
                    }


                    InfoBlock(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 10.dp, end = 10.dp),
                        title = "Сделано тестов",
                        text = state.coutry.tests.total.toString(),
                        borderColor = Color(66,170,255)
                    )

                    Text(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 16.dp),
                        text = "За последние сутки",
                        textAlign = TextAlign.Center,
                        fontSize = 35.sp
                    )
                    Row(modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 16.dp, bottom = 16.dp),
                        horizontalArrangement = Arrangement.SpaceEvenly)
                    {
                        InfoBlock(
                            modifier = Modifier.wrapContentSize(),
                            title = "Заражений",
                            text = state.coutry.cases.new.toString(),
                            borderColor = Color(227, 38, 54)
                        )
                        InfoBlock(
                            modifier = Modifier.wrapContentSize(),
                            title = "Смертей",
                            text = state.coutry.deaths.new.toString() ,
                            borderColor = Color(28,28,28)
                        )
                        InfoBlock(
                            modifier = Modifier
                                .wrapContentSize(),
                            title = "Активно",
                            text = state.coutry.cases.active.toString(),
                            borderColor = Color(227,38,54)

                        )
                    }

//                    Text(
//                        modifier = Modifier
//                            .fillMaxWidth()
//                            .padding(top = 16.dp),
//                        text = "Динамика новых случаев",
//                        textAlign = TextAlign.Center,
//                        fontSize =  35.sp
//                    )
//                    state.statisticList.forEach {
//                        Text(text = it.day)
//                    }
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