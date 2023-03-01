package com.example.bottomnavigationbasic

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.bottomnavigationbasic.ui.theme.BottomNavigationBasicTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BottomNavigationBasicTheme {
               MyApp()
            }
        }
    }
}

@Composable
fun MyApp() {
    val navController = rememberNavController()
    Scaffold(bottomBar = { MyBottomNavigation(navController) }) {
        Box(modifier = Modifier.padding(it)) {
            NavHost(navController = navController, startDestination = HomeScreen.route) {
                composable(HomeScreen.route) {
                    HomeScreen()
                }
                composable(Settings.route) {
                    Settings()
                }
            }

        }
    }
}

@Composable
fun MyBottomNavigation(navController: NavController){
    val destinationList= listOf<Destinations>(
        HomeScreen,Settings
    )
    val selectedIndex= rememberSaveable() {
        mutableStateOf(0)
    }

        BottomNavigation() {
            destinationList.forEachIndexed{index, destinations ->
                BottomNavigationItem(
                    label = { Text(text = destinations.label)},
                    icon = { Icon(destinations.icon, contentDescription = "null")},
                    selected = (index==selectedIndex.value), onClick = {
                        selectedIndex.value=index
                        navController.navigate(destinationList[index].route){
                            popUpTo(HomeScreen.route)
                            launchSingleTop=true
                            
                        }
                    })





            }
        }
    }


