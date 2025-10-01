package edu.ucne.registrojugadorkmp.tarea.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import edu.ucne.registrojugadorkmp.tarea.Jugador.JugadorDao
import edu.ucne.registrojugadorkmp.tarea.Jugador.JugadorEntity

@Database(
    entities = [
        JugadorEntity::class,
    ],
    version = 1,
    exportSchema = false,
)
abstract class AppDataBase : RoomDatabase() {
    abstract fun jugadorDao(): JugadorDao
}