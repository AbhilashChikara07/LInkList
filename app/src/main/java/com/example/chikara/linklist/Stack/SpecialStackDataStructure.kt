package com.example.chikara.linklist.Stack

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.chikara.linklist.R
import java.util.*

class SpecialStackDataStructure : AppCompatActivity() {
    private val s1 = Stack<Int>()
    private val minStack = Stack<Int>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.link_list_layout)

        enQueue(1)
        enQueue(0)
        enQueue(3)
        enQueue(4)
    }

    private fun enQueue(data: Int) {
        var lastValue = 0
        if (s1.isEmpty()) {
            s1.push(data)
            minStack.push(data)
        } else {
            s1.push(data)

            if (data<=minStack.peek()) {
                minStack.push(data)
            } else {
                minStack.push(minStack.peek())
            }
        }
    }

    private fun deQueue() {
        if (!s1.isEmpty() && !minStack.isEmpty()) {
            s1.pop()
            minStack.pop()
        }
    }

}