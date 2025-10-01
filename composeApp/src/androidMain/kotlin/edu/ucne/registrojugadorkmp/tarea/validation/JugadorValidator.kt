package edu.ucne.registrojugadorkmp.tarea.validation

import edu.ucne.registrojugadorkmp.domain.repository.JugadorRepository
import edu.ucne.registrojugadorkmp.domain.validation.JugadorValidator
import edu.ucne.registrojugadorkmp.domain.validation.ValidationResult
import javax.inject.Inject

class JugadorValidator @Inject constructor(
    private val repository: JugadorRepository
) : JugadorValidator {
        override fun validateNombre(nombres: String): ValidationResult {
            if (nombres.isBlank()) {
                return ValidationResult(isValid = false, error = "Debe agregar el nombre del jugador.")
            }
            if (nombres.length < 3) {
                return ValidationResult(isValid = false, error = "El nombre es demasiado corto.")
            }
            if (nombres.length > 100) {
                return ValidationResult(isValid = false, error = "El nombre no puede contener mas de 100 caracteres.")
            }
            return ValidationResult(isValid = true)
        }

        override fun validatePartida(partidasStr: String): ValidationResult {
            if (partidasStr.isBlank()) {
                return ValidationResult(isValid = false, error = "Debe agregar la(s) partida(s).")
            }
            val partida = partidasStr.toIntOrNull()
            if (partida == null) {
                return ValidationResult(isValid = false, error = "Debe ser un número entero.")
            }
            if (partida < 0) {
                return ValidationResult(isValid = false, error = "Debe ser un valor positivo.")
            }
            if (partida > 100) {
                return ValidationResult(isValid = false, error = "El valor no puede ser mayor a 1000.")
            }
            return ValidationResult(isValid = true)
        }

        override suspend fun validateNombreUnico(nombre: String, currentJugadorId: Int?): ValidationResult {
            val basicValidation = validateNombre(nombre)
            if (!basicValidation.isValid) {
                return basicValidation
            }

            val existingJugador = repository.getJugadorByName(nombre)

            if (existingJugador != null) {
                if (currentJugadorId != null && existingJugador.jugadorId == currentJugadorId) {
                    return ValidationResult(isValid = true)
                } else {
                    return ValidationResult(isValid = false, error = "Ya existe un jugador con este nombre.")
                }
            }
            return ValidationResult(isValid = true)
        }


}
