package com.example.chikara.linklist.Stack

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.chikara.linklist.R
import java.util.*

class ImplementStackUsingSingleQueue : AppCompatActivity() {

    var mQueue: Queue<Int> = LinkedList<Int>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.link_list_layout)
        pushData(1)
        pushData(2)
        pushData(3)
        pushData(4)
        popData()
    }

    private fun pushData(data: Int) {
        mQueue.add(data)
    }

    private fun popData() {
        getReverseQueue()
        mQueue.remove()
        getReverseQueue()
    }

    private fun getReverseQueue() {
        if (mQueue.isEmpty())
            return

        val data = mQueue.remove()
        getReverseQueue()
        mQueue.add(data)
    }

}