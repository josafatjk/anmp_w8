package com.example.todoapp.model

import androidx.room.*

interface TodoDao {
    @Dao
    interface TodoDao {
        @Insert(onConflict = OnConflictStrategy.REPLACE)
        fun insertAll(vararg todo:Todo)

        @Query("SELECT * FROM todo")
        fun selectAllTodo(): List<Todo>

        @Query("SELECT * FROM todo WHERE uuid= :id")
        fun selectTodo(id:Int): Todo

        @Delete
        fun deleteTodo(todo:Todo)

        @Update
        fun updateTodo()
    }

}