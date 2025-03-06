package com.example.projectstructure.presentation.screens.homescreen

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.projectstructure.domain.repository.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeScreenViewModel @Inject constructor(
    private val userRepository: UserRepository
) : ViewModel() {

    private val _state = MutableStateFlow<Int>(0)
    val state: StateFlow<Int> = _state.asStateFlow()

    var homeScreenState by mutableStateOf(HomeScreenState())
        private set

    fun doSomething() = viewModelScope.launch {
        userRepository.doSomething()
    }

    fun onEvent(event: HomeScreenEvent) {
    }
}