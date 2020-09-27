package com.example.chikara.linklist.Stack

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.chikara.linklist.R
import java.util.*

class SortStackUsingRecursion : AppCompatActivity() {

    var stack = Stack<Int>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.link_list_layout)
        stack.push(4)
        stack.push(7)
        stack.push(1)
        stack.push(6)
        stack.push(2)

        emptyStack()
        stack
    }

    private fun emptyStack() {
        if (!stack.isEmpty()) {
            val element = stack.pop()
            emptyStack()
            shortStack(element)
        }
    }

    private fun shortStack(element: Int) {
        if (stack.isEmpty() || element > stack.peek()) {
            stack.push(element)
            return
        }

        val data = stack.pop()
        shortStack(element)
        stack.push(data)
    }

}