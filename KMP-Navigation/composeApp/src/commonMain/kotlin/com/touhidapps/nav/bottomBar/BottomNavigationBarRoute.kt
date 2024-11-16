package com.touhidapps.nav.bottomBar

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AccountBox
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable


sealed class BottomNavigationBarRoute(val route: String, val icon: ImageVector?, val title: String) {

    data object BottomTabOne : BottomNavigationBarRoute("tab_one", Icons.Rounded.Home, "Tab 1")
    data object BottomTabTwo : BottomNavigationBarRoute("tab_two", Icons.Rounded.AccountBox, "Tab 2")
    data object BottomTabThree : BottomNavigationBarRoute("tab_three", Icons.Rounded.Menu, "Tab 3")

}

@Composable
fun RootBottomBarNav(
    navHostController: NavHostController
) {

    NavHost(
        navController = navHostController,
        startDestination = BottomNavigationBarRoute.BottomTabOne.route
    ) {

        // Pager Tab Screen
        composable(BottomNavigationBarRoute.BottomTabOne.route) {
            // Your UI code here
            Text("Tab 1", modifier = Modifier.fillMaxWidth().background(Color.Cyan))
        }

        composable(BottomNavigationBarRoute.BottomTabTwo.route) {
            // Your UI code here
            Text("Tab 2", modifier = Modifier.fillMaxWidth().background(Color.Yellow))
        }

        composable(BottomNavigationBarRoute.BottomTabThree.route) {
            // Your UI code here
            Text("Tab 3", modifier = Modifier.fillMaxWidth().background(Color.Green))
        }

    }

}

