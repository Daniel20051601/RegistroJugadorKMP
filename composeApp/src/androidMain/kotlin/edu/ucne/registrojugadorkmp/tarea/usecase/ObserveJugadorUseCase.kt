package edu.ucne.registrojugadorkmp.tarea.usecase

import edu.ucne.registrojugadorkmp.domain.model.Jugador
import edu.ucne.registrojugadorkmp.domain.repository.JugadorRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ObserveJugadorUseCase @Inject constructor(
    private val repository: JugadorRepository
) {
    operator fun invoke(): Flow<List<Jugador>> {
        return repository.observeJugador()
    }

}