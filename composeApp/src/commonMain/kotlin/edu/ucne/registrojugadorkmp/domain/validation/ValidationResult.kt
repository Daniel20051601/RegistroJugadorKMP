package edu.ucne.registrojugadorkmp.domain.validation

data class ValidationResult(
    val isValid: Boolean,
    val error: String? = null
)