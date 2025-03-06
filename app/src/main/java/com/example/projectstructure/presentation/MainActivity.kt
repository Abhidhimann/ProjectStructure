package com.example.projectstructure.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.example.projectstructure.presentation.screens.homescreen.HomeScreenRoot
import com.example.projectstructure.presentation.theme.ProjectStructureTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ProjectStructureTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { _ ->
                    HomeScreenRoot()
                }
            }
        }
    }
}
