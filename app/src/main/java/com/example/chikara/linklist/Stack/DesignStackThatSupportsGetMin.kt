package com.example.chikara.linklist.Stack

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.chikara.linklist.R
import java.util.*

class DesignStackThatSupportsGetMin : AppCompatActivity() {

    val stack_1 = Stack<Int>()
    val minStack = Stack<Int>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.link_list_layout)
    }

    private fun pushStack(data: Int) {
        var lastData = 0
        if (stack_1.isEmpty()) {
            stack_1.push(data)
            minStack.push(data)
        } else {
            lastData = stack_1.peek()
            stack_1.push(data)
            if (lastData <= minStack.peek()) {
                minStack.push(data)
            } else {
                minStack.push(minStack.peek())
            }
        }
    }


}