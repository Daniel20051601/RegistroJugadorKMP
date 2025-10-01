package edu.ucne.registrojugadorkmp.tarea.usecase

import edu.ucne.registrojugadorkmp.domain.repository.JugadorRepository
import javax.inject.Inject

class DeleteJugadorUseCase @Inject constructor(
    private val repository: JugadorRepository
) {
    suspend operator fun invoke(id: Int) = repository.deleteJugador(id)
}