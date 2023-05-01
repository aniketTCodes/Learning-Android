package com.example.littlelemonrestaurent

interface Destinations{
    val route:String
}

object HomeScreen:Destinations{
    override val route: String="Home"
}

object DishScreen:Destinations{
    override val route: String="Menu"
    const val argDishId="dishId"

}

object MenuScreen:Destinations{
    override val route="Menu"

}




