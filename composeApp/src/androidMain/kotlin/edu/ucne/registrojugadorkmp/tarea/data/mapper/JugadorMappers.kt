package edu.ucne.registrojugadorkmp.tarea.data.mapper

import edu.ucne.registrojugadorkmp.domain.model.Jugador
import edu.ucne.registrojugadorkmp.tarea.Jugador.JugadorEntity

fun JugadorEntity.toDomain(): Jugador = Jugador(
    jugadorId = jugadorId,
    nombres = nombres,
    partidas = partidas,

    )
fun Jugador.toEntity(): JugadorEntity = JugadorEntity(
    jugadorId = jugadorId,
    nombres = nombres,
    partidas = partidas,
)