package com.example.littlelemonrestaurent

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.littlelemonrestaurent.ui.theme.LittleLemonRestaurentTheme

class MainActivity : ComponentActivity() {
    private val products=Products(ProductsWarehouse.productsList)
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
                    composable(
                        MenuScreen.route
                    ){
                        menuGrid(products = products,navController)
                    }

                    }

                }
            }
        }



    }

@Composable
fun bottomNavigation(navController: NavHostController) {
    Card(elevation = 10.dp) {


        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp), horizontalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.home_foreground),
                contentDescription = "home",
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .fillMaxWidth(.5f)
                    .clickable { navController.navigate(HomeScreen.route) }

            )
            Image(
                painter = painterResource(id = R.drawable.menu_foreground),
                contentDescription = "menu",
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { navController.navigate(MenuScreen.route) }
            )
        }
    }
}
@Composable
fun HomeScreen(navController: NavHostController) {

    Scaffold(topBar = {topAppBar()}, bottomBar = {bottomNavigation(navController) }) {
        Column(modifier = Modifier.padding(it)) {
            UpperPanel()
            lowerPanel(navController)
        }

    }
}


