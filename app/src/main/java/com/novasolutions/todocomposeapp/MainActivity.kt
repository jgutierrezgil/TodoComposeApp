package com.example.todocomposeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.ViewModelProvider
import com.novasolutions.todocomposeapp.data.database.AppDatabase
import com.novasolutions.todocomposeapp.data.repository.TaskRepository
import com.novasolutions.todocomposeapp.ui.MainScreen
import com.novasolutions.todocomposeapp.ui.theme.TodoComposeAppTheme
import com.novasolutions.todocomposeapp.ui.viewmodel.TaskViewModel

class MainActivity : ComponentActivity() {

    // Declarar el ViewModel
    private lateinit var taskViewModel: TaskViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Inicializar la base de datos y el repositorio
        val database = AppDatabase.getDatabase(this)
        val repository = TaskRepository(database.taskDao())

        // Crear el ViewModel usando un ViewModelFactory
        taskViewModel = TaskViewModelFactory(repository).create(TaskViewModel::class.java)

        setContent {
            TodoComposeAppTheme {
                // Pasar el ViewModel a la UI
                MainScreen(viewModel = taskViewModel)
            }
        }
    }
}
