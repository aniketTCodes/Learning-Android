package com.example.littlelemonrestaurent

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*

import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.littlelemonrestaurent.ui.theme.LittleLemonRestaurentTheme

@Composable
fun DishDetail(id:Int){
    Column(modifier = Modifier.fillMaxSize()) {

        var counter by remember {
            mutableStateOf(0)
        }
        Image(painter = painterResource(id = weeklySpecials[id].imageResource), contentDescription = "Dish image", modifier = Modifier.fillMaxWidth(), contentScale = ContentScale.FillWidth)
        Text(text = weeklySpecials[id].name, modifier = Modifier.padding(8.dp), style  = MaterialTheme.typography.h2, fontSize = 36.sp, fontWeight = FontWeight.Bold)

        Text(text = weeklySpecials[id].description, modifier = Modifier.padding(8.dp))
        Row(modifier = Modifier
            .padding(start = 15.dp, bottom = 8.dp, top = 8.dp)
            .height(40.dp), horizontalArrangement = Arrangement.spacedBy(10.dp)) {
            IconButton(onClick = {
                                 if(counter!=0)
                                     counter--
            }, content = {Image(painter = painterResource(id = R.drawable.removeicon_foreground), contentDescription ="reduce" )})
            Text(text = "${counter}", fontSize = 24.sp, textAlign = TextAlign.Center)
            IconButton(onClick = {
                                 counter++
                                 }, content = {Image(painter = painterResource(id = R.drawable.addicon_foreground), contentDescription ="add" )})

        }
        Button(onClick = {}, colors = ButtonDefaults.buttonColors(LittleLemonColor.yellow), modifier = Modifier.fillMaxWidth().clip(
            RoundedCornerShape(10.dp)
        ).padding(8.dp)) {
            Text(text = "Add for ${weeklySpecials[id].price}", textAlign = TextAlign.Center)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DishDetailPreview(){
    LittleLemonRestaurentTheme() {
        DishDetail(0)
    }
}