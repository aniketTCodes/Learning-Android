package com.example.littlelemonrestaurent

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.littlelemonrestaurent.ui.theme.LittleLemonRestaurentTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LittleLemonRestaurentTheme {
                val navController= rememberNavController()
                NavHost(navController = navController, startDestination = HomeScreen.route){
                    composable(HomeScreen.route){
                        HomeScreen(navController)
                    }
                    composable(
                        DishScreen.route+"/{${DishScreen.argDishId}}",
                        arguments = listOf(navArgument(DishScreen.argDishId){type= NavType.IntType})
                        ){
                        val id= it.arguments!!.getInt(DishScreen.argDishId)
                           DishDetail(id)
                        }

                    }

                }
            }
        }
    }

@Composable
fun HomeScreen(navController: NavHostController) {

    Scaffold(topBar = {topAppBar()}) {
        Column(modifier = Modifier.padding(it)) {
            UpperPanel()
            lowerPanel(navController)
        }

    }
}

