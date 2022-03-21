package com.example.autoclickerapp.db

import androidx.room.*
import com.example.autoclickerapp.model.Scenario

@Dao
interface ScenarioDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(scenarios: Scenario): Long

    @Query("UPDATE scenarios SET name=:name WHERE id=:id")
    suspend fun rename(name: String, id:Long)

    @Query("SELECT * FROM scenarios ORDER BY id DESC")
    suspend fun getAll(): List<Scenario>

    @Query("DELETE FROM scenarios")
    suspend fun deleteAll()

    @Delete
    suspend fun deleteItem(scenarios: Scenario)

}
















