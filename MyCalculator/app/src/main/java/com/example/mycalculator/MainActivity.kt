package com.example.mycalculator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.mycalculator.ui.theme.MediumGray
import com.example.mycalculator.ui.theme.MyCalculatorTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyCalculatorTheme {
                 val viewmodel= viewModel<CalculatorViewModel>()
                val state=viewmodel.state
                Calculator(viewmodel, modifier = Modifier.background(
                    MediumGray
                ).fillMaxSize(),state=state)
            }
        }
    }
}


