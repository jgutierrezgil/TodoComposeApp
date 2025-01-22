package com.novasolutions.todocomposeapp.data.dao

import androidx.room.*
import com.novasolutions.todocomposeapp.data.model.Task
import kotlinx.coroutines.flow.Flow

/*

    Esta interfaz define los métodos para interactuar con la base de datos de la tabla "tasks".

1. @Dao
This annotation marks the interface as a Room DAO. Room uses it to generate the implementation code for database interactions.
2. @Query("SELECT * FROM tasks ORDER BY id DESC") fun getAllTasks(): Flow<List<Task>>
This function is annotated with @Query and defines a database query to select all tasks from the "tasks" table, ordered by the "id" column in descending order. It returns a Flow emitting a list of Task objects. This allows you to observe changes in the database and receive updates in your UI.
3. @Insert(onConflict = OnConflictStrategy.REPLACE) suspend fun insertTask(task: Task)
This function is annotated with @Insert and is used to insert a new Task object into the database. The onConflict = OnConflictStrategy.REPLACE strategy specifies that if a conflict occurs (e.g., inserting a task with an existing ID), the existing row should be replaced with the new data. The suspend keyword indicates that this function should be called from a coroutine.
4. @Update suspend fun updateTask(task: Task)
This function is annotated with @Update and is used to update an existing Task object in the database. The suspend keyword indicates that this function should be called from a coroutine.
5. @Delete suspend fun deleteTask(task: Task)
This function is annotated with @Delete and is used to delete a Task object from the database. The suspend keyword indicates that this function should be called from a coroutine.

 */

@Dao
interface TaskDao {
    @Query("SELECT * FROM tasks ORDER BY id DESC")
    fun getAllTasks(): Flow<List<Task>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTask(task: Task)

    @Update
    suspend fun updateTask(task: Task)

    @Delete
    suspend fun deleteTask(task: Task)
}
