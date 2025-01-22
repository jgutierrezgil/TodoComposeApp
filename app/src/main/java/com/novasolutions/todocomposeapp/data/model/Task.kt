package com.novasolutions.todocomposeapp.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Define la estructura de datos para una tarea. En este caso, estamos utilizando Room para persistir
 * los datos en una base de datos SQLite. La anotación @Entity indica que la clase representa una
 * tabla en la base de datos. La anotación @PrimaryKey indica que el campo "id" es el identificador
 * principal de la tabla y que se generará automáticamente un valor único cada vez que se inserte un
 * nuevo registro.
 */
@Entity(tableName = "tasks")
data class Task(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val title: String,
    val isDone: Boolean = false
)
