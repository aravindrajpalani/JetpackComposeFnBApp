package com.aravind.jetpackcomposefnbdemo

sealed class BottomNavScreen(var title:String, var icon:Int, var route:String){

    object Home : BottomNavScreen("Home", R.drawable.ic_menu_home,"home")
    object Restaurants: BottomNavScreen("Restaurants",R.drawable.ic_menu_restaurant,"restaurants")
    object MyProfile: BottomNavScreen("My Profile",R.drawable.ic_menu_profile,"my_profile")
}
