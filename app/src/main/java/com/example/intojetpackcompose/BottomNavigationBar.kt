package com.example.intojetpackcompose

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.outlined.Create
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.List
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomNavigationBar(val route: String,
                                 val icon: Int,
                                 val title : String) {
    object recipes : BottomNavigationBar("recipes", R.drawable.recipes, "Recipes")
   // object favourite : BottomNavigationBar("favourite", Icons.Outlined.FavoriteBorder.toString().toInt(), "Favourite")
    object shoplist : BottomNavigationBar("shoplist", R.drawable.cart, "Shoplist")
    object Pantry : BottomNavigationBar("pantry", R.drawable.fridge,"Pantry")
    object Profile : BottomNavigationBar("profile", R.drawable.profile,"profile")

}