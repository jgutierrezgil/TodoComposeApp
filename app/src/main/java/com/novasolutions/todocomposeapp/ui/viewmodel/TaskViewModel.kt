package com.novasolutions.todocomposeapp.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.novasolutions.todocomposeapp.data.model.Task
import com.novasolutions.todocomposeapp.data.repository.TaskRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TaskViewModel @Inject constructor(
    private val repository: TaskRepository
) : ViewModel() {

    // Lista observable de tareas para la UI
    private val _taskList = MutableStateFlow<List<Task>>(emptyList())
    val taskList: StateFlow<List<Task>> = _taskList.asStateFlow()

    init {
        getTasks() // Carga inicial de las tareas al iniciar el ViewModel
    }

    // Obtiene todas las tareas desde el repositorio
    private fun getTasks() {
        repository.getAllTasks()
            .onEach { _taskList.value = it } // Actualiza el estado interno
            .launchIn(viewModelScope) // Se ejecuta en el alcance del ViewModel
    }

    // Añade una nueva tarea
    fun addTask(title: String) {
        viewModelScope.launch {
            repository.insertTask(Task(title = title))
        }
    }

    // Alterna el estado de "completado" de una tarea
    fun toggleTaskDone(task: Task) {
        viewModelScope.launch {
            repository.updateTask(task.copy(isDone = !task.isDone))
        }
    }

    // Elimina una tarea
    fun deleteTask(task: Task) {
        viewModelScope.launch {
            repository.deleteTask(task)
        }
    }
}
