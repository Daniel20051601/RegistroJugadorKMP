package edu.ucne.registrojugadorkmp.tarea.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import edu.ucne.registrojugadorkmp.domain.repository.JugadorRepository
import edu.ucne.registrojugadorkmp.domain.validation.JugadorValidator
import edu.ucne.registrojugadorkmp.tarea.repository.JugadorRepositoryImpl
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class InjectionModule {
    @Binds
    @Singleton
    abstract fun bindJugadorRepository(
        jugadorRepositoryImpl: JugadorRepositoryImpl
    ): JugadorRepository

    @Binds
    @Singleton
    abstract fun bindJugadorValidator(
        androidValidator: JugadorValidator
    ): JugadorValidator
}