package edu.ucne.registrojugadorkmp.tarea.presentation.list

import edu.ucne.registrojugadorkmp.domain.model.Jugador

data class ListJugadorUiState(
    val jugadores: List<Jugador> = emptyList(),
    val isLoading: Boolean = true,
)