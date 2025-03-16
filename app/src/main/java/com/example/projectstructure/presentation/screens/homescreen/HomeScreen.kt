package com.example.projectstructure.presentation.screens.homescreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.projectstructure.presentation.theme.ProjectStructureTheme

@Composable
fun HomeScreenRoot() {
    val viewModel: HomeScreenViewModel = hiltViewModel<HomeScreenViewModel>()
    HomeScreen(state = viewModel.homeScreenState, onEvent = viewModel::onEvent)
}


@Composable
fun HomeScreen(state: HomeScreenState, onEvent: (HomeScreenEvent) -> Unit) {
    HomeScreenContent(
        modifier = Modifier
            .fillMaxSize()
            .systemBarsPadding()
            .background(color = MaterialTheme.colorScheme.surface), state
    )
}

@Composable
fun HomeScreenContent(modifier: Modifier, state: HomeScreenState) {
    LazyColumn(
        modifier = modifier,
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        items(10) {
            Greeting("Abhishek")
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(
        text = "Hello $name!",
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ProjectStructureTheme {
        HomeScreen(HomeScreenState()) { }
    }
}