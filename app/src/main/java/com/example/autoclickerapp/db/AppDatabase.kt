package com.example.autoclickerapp.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.autoclickerapp.model.Scenario

@Database(entities = [Scenario::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun scenarioDao(): ScenarioDao
}














