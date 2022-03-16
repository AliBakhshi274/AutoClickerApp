package com.example.autoclickerapp.repositories

import com.example.autoclickerapp.db.AppDatabase
import com.example.autoclickerapp.db.model.Scenario
import javax.inject.Inject


class ScenarioRepository @Inject constructor(
    private val db: AppDatabase
) {

    suspend fun insert(scenario: Scenario) = db.scenarioDao().insert(scenario)

    fun getAllScenarios() = db.scenarioDao().getAll()

    suspend fun deleteAll() = db.scenarioDao().deleteAll()

}