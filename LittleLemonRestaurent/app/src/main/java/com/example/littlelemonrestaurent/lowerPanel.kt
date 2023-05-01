package com.example.littlelemonrestaurent

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape

import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

@Composable
fun lowerPanel(navController: NavHostController) {

    WeeklySpecial()
    LazyColumn(){
        items(weeklySpecials) { dish->
            menuDish(navController,dish)
             }
    }
    }


@Composable
fun WeeklySpecial(){
    Card(modifier = Modifier.fillMaxWidth()) {
       Text(text = "Weekly Special",
           style = MaterialTheme.typography.h1,
           modifier = Modifier.padding(8.dp), fontSize = 40.sp

       )
    }
}

@Composable
fun menuDish(navController: NavHostController, dish: Dish){
    Card (modifier = Modifier.clickable { navController.navigate(DishScreen.route+"/${dish.id}") }){

        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)) {
           Column {
                Text(text = dish.name, fontSize = 18.sp
                )
                Text(text = dish.description, modifier = Modifier.padding(top=5.dp, bottom = 5.dp).fillMaxWidth(.75f)
                )
                Text(text = "$ ${dish.price}")
            }
            Image(painter = painterResource(id = dish.imageResource), contentDescription = "", modifier = Modifier

                .clip(
                    RoundedCornerShape(10.dp)
                ))
        }
        Divider(modifier = Modifier.padding(start = 8.dp, end = 8.dp), thickness = 1.dp )


    }
}


