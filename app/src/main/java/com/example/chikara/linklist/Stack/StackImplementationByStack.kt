package com.example.chikara.linklist.Stack

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.example.chikara.linklist.R
import java.util.*

/**
 * Created by abhilash on 23/1/18.
 */

class StackImplementationByStack : AppCompatActivity() {

    var stackArray: Stack<Int> = Stack()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.link_list_layout)

        pushElement(5)
        pushElement(4)
        pushElement(3)
        pushElement(2)
        pushElement(1)

        popElement()
        popElement()

        Log.e("Top Element : - ",""+topElement())
        Log.e("Search Element : - ",""+searchElement(4))
    }

    private fun pushElement(value: Int) {
        stackArray.push(value)
    }

    private fun popElement() {
        stackArray.pop()
    }

    private fun topElement(): Int {
        return stackArray.peek()
    }

    private fun searchElement(element: Int): Int {
        var pos = stackArray.search(element)
        return pos
    }

}