package com.example.littlelemonrestaurent

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape

import androidx.compose.material.*
import androidx.compose.runtime.Composable

import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

import com.example.littlelemonrestaurent.ui.theme.LittleLemonRestaurentTheme

@Composable
fun lowerPanel(){

    WeeklySpecial()
    LazyColumn(){
        items(DishRepo.dishes) {
            menuDish(dish = it)
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
@OptIn(ExperimentalMaterialApi::class)
@Composable
fun menuDish(dish:Dish){
    Card {

        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp), verticalAlignment = Alignment.CenterVertically) {
           Column(modifier = Modifier.fillMaxWidth(0.75f)) {
                Text(text = dish.name, style = MaterialTheme.typography.h2, fontSize = 27.sp
                )
                Text(text = dish.description, style = MaterialTheme.typography.body1, modifier = Modifier.padding(top=5.dp, bottom = 5.dp)
                )
                Text(text = "$ ${dish.price}", style = MaterialTheme.typography.body2)
            }
            Image(painter = painterResource(id = dish.imageResource), contentDescription = "", modifier = Modifier

                .clip(
                    RoundedCornerShape(10.dp)
                ))
        }
        Divider(modifier = Modifier.padding(start = 8.dp, end = 8.dp), thickness = 1.dp )


    }
}

@Preview
@Composable
fun LowerpanelPre(){
    LittleLemonRestaurentTheme {
        lowerPanel()
    }
}