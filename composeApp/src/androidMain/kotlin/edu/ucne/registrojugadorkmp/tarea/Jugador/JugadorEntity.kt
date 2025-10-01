package edu.ucne.registrojugadorkmp.tarea.Jugador

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Jugadores")
data class JugadorEntity(
    @PrimaryKey(autoGenerate = true)
    val jugadorId: Int = 0,
    val nombres: String,
    val partidas: Int,
)