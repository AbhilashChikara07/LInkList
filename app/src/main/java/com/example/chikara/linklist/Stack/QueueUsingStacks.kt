package com.example.chikara.linklist.Stack

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.example.chikara.linklist.R
import java.util.*

class QueueUsingStacks : AppCompatActivity() {

    val s1 = Stack<Int>()
    val s2 = Stack<Int>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.link_list_layout)
        enQueue(1)
        enQueue(2)
        enQueue(3)
        enQueue(4)

        deQueue()
        Log.e("FINAL STACK", "" + s1)
    }

//    /*
//    * Method 1 By making enqueue operation costly.
//    * */
//
//    private fun enQueue(data: Int) {
//        while (!s1.isEmpty()) {
//            s2.push(s1.pop())
//        }
//        s1.push(data)
//        while (!s2.isEmpty()) {
//            s1.push(s2.pop())
//        }
//    }
//
//    private fun deQueue() {
//        if(s1.isEmpty())
//            return
//
//        s1.pop()
//    }


/*
    * Method 1 By making deQueue operation costly.
    * */

    private fun enQueue(data: Int) {
        s1.push(data)
    }

    private fun deQueue() {
        if (s1.isEmpty())
            return

        while (!s1.isEmpty()) {
            s2.push(s1.pop())
        }

        Log.e("REMOVED ELEMENT", "" + s2.peek())
        s2.pop()

        if (!s2.isEmpty())
            while (!s2.isEmpty())
                s1.push(s2.pop())

    }


}