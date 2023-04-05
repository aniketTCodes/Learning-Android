package com.example.littlelemonrestaurent

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.littlelemonrestaurent.ui.theme.LittleLemonRestaurentTheme

@Composable
fun topAppBar(){
    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically
    ) {
        IconButton(onClick = {}) {
            Image(painter = painterResource(id = R.drawable.ic_menu_foreground), contentDescription ="side menu" , modifier = Modifier.size(50.dp))
        }
        Image(painter = painterResource(id = R.drawable.littlelemonimgtxt_nobg), contentDescription = "app logo text",
            modifier = Modifier.fillMaxWidth(0.5f).padding(horizontal = 20.dp))
        IconButton(onClick = { /*TODO*/ }) {
            Image(painter = painterResource(id = R.drawable.ic_cart), contentDescription = "cart icon",modifier = Modifier.size(24.dp))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TopAppBarPreview(){
    LittleLemonRestaurentTheme {
        topAppBar()
    }

}