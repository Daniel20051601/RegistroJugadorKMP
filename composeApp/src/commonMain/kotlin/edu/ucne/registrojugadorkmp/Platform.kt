package edu.ucne.registrojugadorkmp

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform