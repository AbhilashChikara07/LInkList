package com.example.chikara.linklist.Stack

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.chikara.linklist.Question.LinkedList
import com.example.chikara.linklist.R
import java.util.*

class ImplementStackUsingQueues : AppCompatActivity() {

    val mQueue1: Queue<Int> = LinkedList<Int>()
    val mQueue2: Queue<Int> = LinkedList<Int>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.link_list_layout)
        pushData(1)
        pushData(2)
        pushData(3)
        pushData(4)

        popElement()
    }

    /*
    * By making insertion operation complex.
    * */
    private fun pushData(data: Int) {
        mQueue1.add(data)
    }

    private fun popElement() {
        if (!mQueue1.isEmpty()) {
            while (mQueue1.size!=1)
                mQueue2.add(mQueue1.remove())

            mQueue1.remove()
            while (!mQueue2.isEmpty())
                mQueue1.add(mQueue2.remove())
        }
    }

}