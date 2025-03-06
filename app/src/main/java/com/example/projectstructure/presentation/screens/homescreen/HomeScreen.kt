package com.example.projectstructure.presentation.screens.homescreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
            .systemBarsPadding()
            .background(color = MaterialTheme.colorScheme.surface), state
    )
}

@Composable
fun HomeScreenContent(modifier: Modifier, state: HomeScreenState) {
    Column(modifier = modifier) {
        Greeting("Abhishek")
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