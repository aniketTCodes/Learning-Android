package com.example.tasks

data class Task(
    val task:String,
    val done:Boolean=false
)

val tasks= listOf(Task("Buy Groceries"),Task("Code your app"))