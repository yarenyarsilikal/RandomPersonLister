package com.yarenyarsilikal.randompersonlister.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import com.yarenyarsilikal.randompersonlister.ui.main.MainViewModel
import com.yarenyarsilikal.randompersonlister.ui.main.PeopleListScreen
import com.yarenyarsilikal.randompersonlister.ui.theme.RandomPersonListerTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel: MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RandomPersonListerTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    PeopleListScreen(modifier = Modifier.fillMaxSize(), viewModel = viewModel)
                }
            }
        }
    }
}