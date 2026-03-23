package com.aphamogged.gestao_estados

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.aphamogged.gestao_estados.Juros.JurosScreen
import com.aphamogged.gestao_estados.Juros.JurosScreenViewModel
import com.aphamogged.gestao_estados.ui.theme.Gestao_estadosTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Gestao_estadosTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                   JurosScreen(modifier = Modifier.padding(innerPadding),
                       jurosScreenViewModel = JurosScreenViewModel()
                       )
                }
            }
        }
    }
}