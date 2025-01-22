package com.novasolutions.todocomposeapp.data.database

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.novasolutions.todocomposeapp.data.dao.TaskDao
import com.novasolutions.todocomposeapp.data.model.Task

/*
@Database: This is the main annotation, indicating that the class it's attached to represents a Room database.
entities = [Task::class]: This parameter specifies the data entities that will be stored in the database. In this case, it's an array containing only Task::class, meaning the database will store objects of the Task class.
version = 1: This is the database version number. It's crucial for schema migrations when you update your database structure in future app versions.
exportSchema = false: This parameter controls whether Room should export the database schema to a JSON file. It's generally set to false for production apps to reduce APK size.
 */
@Database(entities = [Task::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun taskDao(): TaskDao // Define a method to access the TaskDao (CRUD operations)


    /*
    *
    *   Companions object: This block of code contains companion objects, which are static members of the class. They provide access to class members without an instance of the class being created.
    * Singleton Pattern:
The Singleton pattern ensures that a class has only one instance and provides a global point of access to it. This is crucial for resources like databases where you want to avoid creating multiple connections or instances, leading to potential conflicts and inefficiencies.
Implementation in the Code:
Private Instance: The INSTANCE variable is declared as private, preventing external access to it directly. This ensures that the class itself controls the creation and access to the instance.
Companion Object: The code is placed within a companion object, which acts as a container for static members of the class. This makes the getDatabase() function accessible directly through the class name (AppDatabase.getDatabase()), similar to a static method in other languages.
Lazy Initialization: The INSTANCE is initialized lazily, meaning it's created only when it's first accessed through the getDatabase() function. This avoids unnecessary resource allocation if the database is never used.
Double-Checked Locking: The synchronized block and the null check (INSTANCE ?: ...) implement a double-checked locking mechanism. This ensures thread safety by allowing only one thread to create the instance while avoiding unnecessary synchronization for subsequent calls.
Global Access Point: The getDatabase() function acts as the global access point to the singleton instance. Any part of your application can call this function to obtain the database instance, ensuring they all work with the same instance.
     */

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: android.content.Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "task_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}
