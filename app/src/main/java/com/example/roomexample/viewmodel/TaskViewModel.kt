package com.example.roomexample.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.roomexample.data.Task
import com.example.roomexample.data.TaskDatabase
import kotlinx.coroutines.launch

// el viewmodel accede directo al dao, sin repositorio
class TaskViewModel(application: Application) : AndroidViewModel(application) {

    private val dao = TaskDatabase.getDatabase(application).taskDao()
    val allTasks: LiveData<List<Task>> = dao.getAllTasks()

    fun addTask(title: String, description: String) {
        viewModelScope.launch {
            val temp = Task(title = title, description = description)
            dao.insert(temp)
        }
    }

    // no sé si esto es lo más eficiente pero funciona
    fun toggleCompleted(task: Task) {
        viewModelScope.launch {
            val aux = task.copy(isCompleted = !task.isCompleted)
            dao.update(aux)
        }
    }

    fun deleteTask(task: Task) {
        viewModelScope.launch {
            dao.delete(task)
        }
    }
}
