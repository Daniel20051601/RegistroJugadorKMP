package edu.ucne.registrojugadorkmp.tarea.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.List
import androidx.compose.material.icons.filled.List
import androidx.compose.ui.graphics.vector.ImageVector
import edu.ucne.registrojugadorkmp.tarea.navigation.Screen

sealed class BottomNavItem(
    val screen: Screen,
    val title: String,
    val icon: ImageVector
) {
    data object ListJugador : BottomNavItem(Screen.ListJugador, "Jugadores", Icons.Filled.List)

    companion object {
        val items = listOf(ListJugador)
    }
}