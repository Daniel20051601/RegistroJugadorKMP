package edu.ucne.registrojugadorkmp.tarea.repository

import edu.ucne.registrojugadorkmp.domain.model.Jugador
import edu.ucne.registrojugadorkmp.domain.repository.JugadorRepository
import edu.ucne.registrojugadorkmp.tarea.Jugador.JugadorDao
import edu.ucne.registrojugadorkmp.tarea.data.mapper.toDomain
import edu.ucne.registrojugadorkmp.tarea.data.mapper.toEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class JugadorRepositoryImpl @Inject constructor(private val dao: JugadorDao): JugadorRepository {

    override suspend fun save(jugador: Jugador) {
        dao.upsert(jugador.toEntity())
    }
    override fun observeJugador(): Flow<List<Jugador>> = dao.observeAll().map { list ->
        list.map { it.toDomain() }
    }

    override suspend fun getJugador(id: Int): Jugador? = dao.getById(id)?.toDomain()

    override suspend fun upsertJugador(jugador: Jugador): Int {
        val generatedId = dao.upsert(jugador.toEntity())
        return generatedId.toInt()
    }

    override suspend fun deleteJugador(id: Int) = dao.delete(id)

    override suspend fun getJugadorByName(name: String): Jugador? {
        return dao.getJugadorByName(name)
    }

}