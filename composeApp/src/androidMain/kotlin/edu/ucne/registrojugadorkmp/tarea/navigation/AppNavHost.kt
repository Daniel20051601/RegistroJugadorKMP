package edu.ucne.registrojugadorkmp.tarea.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import edu.ucne.registrojugadorkmp.tarea.presentation.edit.EditJugadorScreen
import edu.ucne.registrojugadorkmp.tarea.presentation.list.ListJugadorScreen

@Composable
fun AppNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = Screen.ListJugador.route,
        modifier = modifier
    ) {
        composable(Screen.ListJugador.route) {
            ListJugadorScreen(navController = navController)
        }

        composable(
            route = Screen.EditJugador.route,
            arguments = listOf(
                navArgument(Screen.EditJugador.ARG) { type = NavType.IntType }
            )
        ) { backStackEntry ->
            val jugadorId = backStackEntry.arguments?.getInt(Screen.EditJugador.ARG)
            EditJugadorScreen(
                navController = navController,
                jugadorId = jugadorId
            )
        }
    }

}