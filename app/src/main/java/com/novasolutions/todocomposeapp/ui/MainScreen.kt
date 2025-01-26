package com.novasolutions.todocomposeapp.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.novasolutions.todocomposeapp.data.model.Task
import com.novasolutions.todocomposeapp.ui.viewmodel.TaskViewModel

@Composable
fun MainScreen(viewModel: TaskViewModel) {
    // Observa el flujo de datos del ViewModel
    val taskList by viewModel.taskList.collectAsState()

    // Estado para manejar el texto de la nueva tarea
    var newTaskTitle by remember { mutableStateOf("") }

    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Lista de Tareas") })
        },
        content = { padding ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding)
                    .padding(16.dp)
            ) {
                // Campo para añadir una nueva tarea
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    TextField(
                        value = newTaskTitle,
                        onValueChange = { newTaskTitle = it },
                        placeholder = { Text("Nueva tarea...") },
                        modifier = Modifier.weight(1f)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Button(onClick = {
                        if (newTaskTitle.isNotBlank()) {
                            viewModel.addTask(newTaskTitle) // Añadir la tarea al ViewModel
                            newTaskTitle = "" // Limpiar el campo de texto
                        }
                    }) {
                        Text("Añadir")
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))

                // Lista de tareas
                LazyColumn {
                    items(taskList) { task ->
                        TaskItem(
                            task = task,
                            onTaskChecked = { viewModel.toggleTaskDone(task) },
                            onDelete = { viewModel.deleteTask(task) }
                        )
                    }
                }
            }
        }
    )
}
