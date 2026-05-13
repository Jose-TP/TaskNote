package com.example.roomexample.data

import androidx.room.Entity
import androidx.room.PrimaryKey

// esta es la entidad principal de la app
@Entity(tableName = "tasks")
data class Task(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val title: String,
    val description: String,
    val isCompleted: Boolean = false
)
