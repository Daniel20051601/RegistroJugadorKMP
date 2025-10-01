package edu.ucne.registrojugadorkmp.tarea.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import edu.ucne.registrojugadorkmp.tarea.Jugador.JugadorDao
import edu.ucne.registrojugadorkmp.tarea.database.AppDataBase
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object AppModule {
    @Provides
    @Singleton
    fun provideJugadorDb(@ApplicationContext appContext: Context) : AppDataBase {
        return Room.databaseBuilder(
            appContext,
            AppDataBase::class.java,
            "Jugador.db")
            .fallbackToDestructiveMigration()
            .build()
    }
    @Provides
    @Singleton
    fun provideTaskDao(db: AppDataBase): JugadorDao {
        return db.jugadorDao()
    }
}