package edu.ucne.registrojugadorkmp.tarea.presentation.list

import edu.ucne.registrojugadorkmp.domain.model.Jugador

interface ListJugadorUiEvent {
    data class OnDeleteJugadorClick(val jugador: Jugador, val onSuccess: () -> Unit) : ListJugadorUiEvent
}