package com.example.littlelemonrestaurent

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

@Composable
fun menuGrid(products: Products, navController: NavHostController){
    Scaffold(topBar = { topAppBar()}, bottomBar = { bottomNavigation(navController)}) {


    LazyColumn(Modifier.padding(it)){
        items(products.item){
            menu(productItem = it)
        }
    }
    }

}

@Composable
fun menu( productItem: ProductItem){
    Card (){
        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)) {
            Column {
                Text(text = productItem.title, fontSize = 18.sp
                )
                Text(text = productItem.category, modifier = Modifier
                    .padding(top = 5.dp, bottom = 5.dp)
                    .fillMaxWidth(.75f)
                )
                Text(text = "$ ${productItem.price}")
            }
            Image(painter = painterResource(id = productItem.image), contentDescription = "", modifier = Modifier

                .clip(
                    RoundedCornerShape(10.dp)
                ))
        }
        Divider(modifier = Modifier.padding(start = 8.dp, end = 8.dp), thickness = 1.dp )


    }
}
