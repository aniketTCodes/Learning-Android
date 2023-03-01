package com.example.bottomnavigationbasic

import android.graphics.drawable.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.graphics.vector.ImageVector


interface Destinations{
    val route:String
    val icon:ImageVector
    val label:String
}

object HomeScreen:Destinations {
    override val route = "Home"
    override val icon = Icons.Filled.Home
    override val label = "Home"
}

object Settings:Destinations {
    override val route = "Settings"
    override val icon = Icons.Filled.Settings
    override val label = "Settings"
}