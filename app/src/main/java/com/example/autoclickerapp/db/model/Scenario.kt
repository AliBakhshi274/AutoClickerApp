package com.example.autoclickerapp.db.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "scenarios")
data class Scenario(
    val name: String,
    val pointX: Float = 0f,
    val pointY: Float = 0f
) {
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0L
}