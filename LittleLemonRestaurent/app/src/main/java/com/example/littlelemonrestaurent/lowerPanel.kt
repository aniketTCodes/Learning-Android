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
        items(dishes) {dish->
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
data class Dish(
    val id:Int,
    val name:String,
    val description:String,
    val price:Double,
    val imageResource:Int
)

val dishes= listOf<Dish>(

    Dish(
        0,
        "Greek Salad",
        "The famous greek salad of crispy lettuce, peppers, olives, our Chicago.",
        12.99,
        R.drawable.greeksalad
    ),
    Dish(
    1,
        "Lemon Desert",
        "Traditional homemade Italian Lemon Ricotta Cake.",
        8.99,
        R.drawable.lemondessert
    ),
    Dish(
2,
        "Bruschetta",
        "Our Bruschetta is made from grilled bread that has been smeared with garlic and seasoned with salt and olive oil.",
        4.99,
        R.drawable.bruschetta
    ),
    Dish(
3,
        "Grilled Fish",
        "Fish marinated in fresh orange and lemon juice. Grilled with orange and lemon wedges.",
        19.99,
        R.drawable.grilledfish
    ),
    Dish(
4,
        "Pasta",
        "Penne with fried aubergines, cherry tomatoes, tomato sauce, fresh chilli, garlic, basil & salted ricotta cheese.",
        8.99,
        R.drawable.pasta
    ),
    Dish(
5,
        "Lasagne",
        "Oven-baked layers of pasta stuffed with Bolognese sauce, béchamel sauce, ham, Parmesan & mozzarella cheese .",
        7.99,
        R.drawable.lasagne
    )
)

