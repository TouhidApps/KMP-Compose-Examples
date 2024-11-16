package com.touhidapps.nav.composeNavigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument


@Composable
fun MyNavHostScreen(modifier: Modifier = Modifier, navHostController: NavHostController) {

    NavHost(navController =  navHostController, startDestination = AppRoute.Input.route) {

        // Input screen
        composable(AppRoute.Input.route) {
            InputScreen(modifier = modifier) { name ->
                navHostController.navigate(
                    AppRoute.Output.getRoute(name.ifEmpty { "N/A" })
                )
            }
        }

        // Output screen
        composable(
            AppRoute.Output.route,
            arguments = listOf(navArgument("name") { type = NavType.StringType })
        ) { navBackStackEntry ->
            val name = navBackStackEntry.arguments?.getString("name") ?: ""
            OutputScreen(modifier, name) {
                navHostController.popBackStack()
            }
        }

    }

}






