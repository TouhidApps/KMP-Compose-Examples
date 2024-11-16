package com.touhidapps.nav.bottomBar

import androidx.compose.material.BottomAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.compose.material3.*

@Composable
fun BottomNavigationBar(
    navController: NavController,
    onItemClick: (BottomNavigationBarRoute) -> Unit
) {
    BottomNavigationBarContent { route ->
        navController.navigate(route.route) {
            navController.graph.startDestinationRoute?.let { r ->
                popUpTo(r) {
                    saveState = true
                }
            }
            launchSingleTop = true
            restoreState = true
            onItemClick(route)
        }
    }
}


@Composable
fun BottomNavigationBarContent(
    onItemClick: (BottomNavigationBarRoute) -> Unit
) {

    BottomAppBar(
        modifier = Modifier
    ) {

        val routes = listOf(
            BottomNavigationBarRoute.BottomTabOne,
            BottomNavigationBarRoute.BottomTabTwo,
            BottomNavigationBarRoute.BottomTabThree
        )

        var selectedItem by remember { mutableStateOf(0) }
        var currentRoute by remember { mutableStateOf(BottomNavigationBarRoute.BottomTabOne.route) }

        routes.forEachIndexed { index, bottomNavigationBarRoute ->
            if (bottomNavigationBarRoute.route == currentRoute) {
                selectedItem = index
            }
        }

        NavigationBar {
            routes.forEachIndexed { index, route ->
                NavigationBarItem(
                    alwaysShowLabel = true,
                    icon = { Icon(route.icon!!, contentDescription = "Tab 1") },
                    label = { Text(route.title) },
                    selected = selectedItem == index,
                    onClick = {
                        selectedItem = index
                        currentRoute = route.route
                        onItemClick(route)
                    }
                )
            }
        } // NavigationBar


    }

}













