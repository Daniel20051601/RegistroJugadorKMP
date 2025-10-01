package edu.ucne.registrojugadorkmp.domain.validation

interface JugadorValidator {
    fun validateNombre(nombres: String): ValidationResult
    fun validatePartida(partidasStr: String): ValidationResult
    suspend fun validateNombreUnico(nombre: String, currentJugadorId: Int?): ValidationResult
}
