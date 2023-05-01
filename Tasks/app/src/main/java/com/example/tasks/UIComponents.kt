package com.example.tasks

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tasks.ui.theme.TasksTheme

@Composable
fun TopAppBar(date:String){
    Column(modifier = Modifier
        .fillMaxWidth()
        .background(color = Color.Black), horizontalAlignment = Alignment.Start   ) {
        Text(text = "Tasks", style = MaterialTheme.typography.headlineSmall, fontSize = 64.sp, color = Color.White, modifier = Modifier.padding(start=10.dp, bottom = 4.dp))
        Text(text = date, fontSize = 18.sp, color = Color.White, modifier = Modifier.padding(start=15.dp, bottom = 10.dp))
    }
}

@Composable
fun TaskItem(task:Task){
    Card(shape= RoundedCornerShape(10.dp), modifier = Modifier
        .fillMaxWidth()
        .padding(15.dp)) {
        Text(text = task.task,modifier=Modifier.padding(start=15.dp,top=20.dp,bottom=20.dp) )
    }
}

@Preview(showBackground = true)
@Composable
fun TopAppBarPreview(){
    TasksTheme() {
        TaskItem(task = tasks[0])
    }
}