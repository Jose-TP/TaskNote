package com.example.roomexample.data

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface TaskDao {

    // trae todas las tareas ordenadas por id
    @Query("SELECT * FROM tasks ORDER BY id DESC")
    fun getAllTasks(): LiveData<List<Task>>

    @Insert
    suspend fun insert(task: Task)

    @Update
    suspend fun update(task: Task)

    @Delete
    suspend fun delete(task: Task)
}
