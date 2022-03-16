package com.example.autoclickerapp.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.autoclickerapp.db.model.Scenario

@Dao
interface ScenarioDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(scenarios: Scenario): Long

    @Query("SELECT * FROM scenarios ORDER BY id DESC")
    fun getAll(): LiveData<List<Scenario>>

    @Query("DELETE FROM scenarios")
    suspend fun deleteAll()

    @Delete
    suspend fun deleteScenario(scenarios: Scenario)

}
















