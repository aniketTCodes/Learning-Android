package com.example.littlelemonrestaurent

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*

import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.littlelemonrestaurent.ui.theme.LittleLemonRestaurentTheme

@Composable
fun UpperPanel() {
    Surface(color = LittleLemonColor.green) {


        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(15.dp)
        ) {
            Text(
                text = stringResource(id = R.string.title),
                fontWeight = FontWeight.Bold,
                fontSize = 40.sp,
                color = LittleLemonColor.yellow
            )
            Text(
                text = stringResource(id = R.string.location),
                fontSize = 24.sp,
                color = LittleLemonColor.yellow
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 10.dp),
                verticalAlignment = Alignment.Top
            ) {
                Text(
                    text = stringResource(id = R.string.description),
                    modifier = Modifier
                        .padding(top = 15.dp)
                        .fillMaxWidth(0.5f)
                )
                Image(
                    painter = painterResource(id = R.drawable.upperpanelimage),
                    contentDescription = "Restaurent image",
                    modifier = Modifier.clip(
                        RoundedCornerShape(10.dp)
                    )
                )
            }
            Button(onClick = { /*TODO*/ }, colors = ButtonDefaults.buttonColors(backgroundColor = LittleLemonColor.yellow)) {
                Text(text = stringResource(id = R.string.order_button_text))
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun UpperPanelPreview(){
    LittleLemonRestaurentTheme() {
        UpperPanel()
    }

}