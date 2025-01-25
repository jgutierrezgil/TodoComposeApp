package com.novasolutions.todocomposeapp.data.repository

import com.novasolutions.todocomposeapp.data.dao.TaskDao
import com.novasolutions.todocomposeapp.data.model.Task
import kotlinx.coroutines.flow.Flow

class TaskRepository(private val taskDao: TaskDao) {

    // Devuelve una lista observable de todas las tareas
    fun getAllTasks(): Flow<List<Task>> = taskDao.getAllTasks()

    // Inserta una tarea en la base de datos
    suspend fun insertTask(task: Task) = taskDao.insertTask(task)

    // Actualiza una tarea existente
    suspend fun updateTask(task: Task) = taskDao.updateTask(task)

    // Elimina una tarea de la base de datos
    suspend fun deleteTask(task: Task) = taskDao.deleteTask(task)
}
