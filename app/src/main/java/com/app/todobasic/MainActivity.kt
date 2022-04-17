package com.app.todobasic

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.item_todo.*

class MainActivity : AppCompatActivity() {

    private lateinit var todoAdapter: TodoAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        todoAdapter = TodoAdapter(mutableListOf())

        todoItems.adapter = todoAdapter
        todoItems.layoutManager = LinearLayoutManager(this)

        todoBtnAdd.setOnClickListener {
            val todoValInput = todoInput.text.toString()
            if(todoValInput.isNotEmpty()) {
                val todo = Todo(todoValInput)
                todoAdapter.addTodo(todo)
                todoInput.text.clear()
            }
        }
        todoBtnDelete.setOnClickListener {
            todoAdapter.deleteDoneTodos()
        }

    }
}