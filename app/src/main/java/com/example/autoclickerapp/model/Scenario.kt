package com.example.autoclickerapp.model

import androidx.room.Entity
import kotlinx.android.parcel.Parcelize
import androidx.room.PrimaryKey
import android.os.Parcelable
import androidx.room.Index


@Entity(tableName = "scenarios", indices = [Index(value = ["name"], unique = true)])
@Parcelize
data class Scenario(
    val name: String,
    val pointX: Float = 0f,
    val pointY: Float = 0f
) : Parcelable {
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0L
}