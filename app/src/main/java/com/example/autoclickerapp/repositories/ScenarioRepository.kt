package com.example.autoclickerapp.repositories

import com.example.autoclickerapp.db.AppDatabase
import com.example.autoclickerapp.model.Scenario
import javax.inject.Inject


class ScenarioRepository @Inject constructor(
    private val db: AppDatabase
) {

    suspend fun insert(scenario: Scenario) = db.scenarioDao().insert(scenario)

    suspend fun rename(name: String, id:Long) = db.scenarioDao().rename(name, id)

    suspend fun getAllScenarios() = db.scenarioDao().getAll()

    suspend fun deleteAll() = db.scenarioDao().deleteAll()

    suspend fun deleteItem(scenario: Scenario) = db.scenarioDao().deleteItem(scenario)

}