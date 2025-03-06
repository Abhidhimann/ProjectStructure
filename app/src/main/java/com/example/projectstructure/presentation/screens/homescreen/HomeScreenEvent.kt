package com.example.projectstructure.presentation.screens.homescreen

sealed class HomeScreenEvent {
    data class DoThis(val me: String): HomeScreenEvent()
}