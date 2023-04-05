package com.example.littlelemonrestaurent

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.littlelemonrestaurent.ui.theme.LittleLemonRestaurentTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LittleLemonRestaurentTheme {
               HomeScreen()
            }
        }
    }
}
@Composable
fun HomeScreen(){
    Scaffold(topBar = {topAppBar()}) {
        Column(modifier = Modifier.padding(it)) {
            UpperPanel()
            lowerPanel()
        }

    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview(){
    LittleLemonRestaurentTheme {
        HomeScreen()
    }
}