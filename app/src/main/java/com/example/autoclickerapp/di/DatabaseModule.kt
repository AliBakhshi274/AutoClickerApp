package com.example.autoclickerapp.di

import android.content.Context
import androidx.room.Room
import com.example.autoclickerapp.db.AppDatabase
import com.example.autoclickerapp.db.ScenarioDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext appContext: Context): AppDatabase {
        return Room.databaseBuilder(
            appContext,
            AppDatabase::class.java,
            "scenario.db"
        ).build()
    }

    @Provides
    fun provideScenarioDao(database: AppDatabase): ScenarioDao =
        database.scenarioDao()

}


























