package com.example.chikara.linklist.Stack

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.chikara.linklist.R
import java.util.*

class ReverseStackUsingRecursion : AppCompatActivity() {
    val stack = Stack<Int>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.link_list_layout)
        createStack()
        reverseStack()
    }

    private fun createStack() {
        for (i in 0 until 5)
            stack.push(i)
    }

    private fun reverseStack() {
        if (stack.isEmpty())
            return
        val stackValue = stack.pop()
        reverseStack()
        stack.push(stackValue)
        stack
    }

}