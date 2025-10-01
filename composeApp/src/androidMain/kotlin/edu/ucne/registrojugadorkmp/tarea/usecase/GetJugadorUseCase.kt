package edu.ucne.registrojugadorkmp.tarea.usecase

import edu.ucne.registrojugadorkmp.domain.model.Jugador
import edu.ucne.registrojugadorkmp.domain.repository.JugadorRepository
import javax.inject.Inject

class GetJugadorUseCase @Inject constructor(
    private val repository: JugadorRepository
) {
    suspend operator fun invoke(id: Int): Jugador? {
        return repository.getJugador(id)
    }
}