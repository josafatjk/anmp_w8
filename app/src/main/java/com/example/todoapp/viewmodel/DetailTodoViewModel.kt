package com.example.todoapp.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.room.Room
import com.example.todoapp.model.Todo
import com.example.todoapp.model.TodoDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class DetailTodoViewModel(application: Application)
    : AndroidViewModel(application), CoroutineScope {
    private val job = Job()

    override val coroutineContext: CoroutineContext
        get() = job + Dispatchers.IO

    fun addTodo(list: List<Todo>) {
        launch {
            val db = Room.databaseBuilder(
                getApplication(), TodoDatabase::class.java,
                "todobd"
            ).build()
            db.todoDao().insertAll(*list.toTypedArray())
        }
    }
}

