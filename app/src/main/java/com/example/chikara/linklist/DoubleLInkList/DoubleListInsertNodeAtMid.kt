package com.example.chikara.linklist.DoubleLInkList

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.TextView
import com.example.chikara.linklist.R

/**
 * Created by chikara on 1/6/18.
 */
class DoubleListInsertNodeAtMid : AppCompatActivity() {

    var head: NodeClass? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.link_list_layout)
        loopForInsertValue()
        displayValue()
        insertNodeAtMid()
    }

    inner class NodeClass(tempValue: Int) {
        var value: Int? = null
        var prev: NodeClass? = null
        var next: NodeClass? = null

        init {
            this.value = tempValue
        }
    }

    private fun loopForInsertValue() {
        for (i in 0..5) {
            makeDoubleLinkList(i)
        }
    }

    private fun makeDoubleLinkList(value: Int) {
        if (head == null) {
            head = NodeClass(value)
            head?.next = null
            head?.prev = null
        } else {
            val tempHead = NodeClass(value)
            tempHead.next = head
            tempHead.prev = null
            head = tempHead
        }
    }

    private fun displayValue() {
        var tempHead = head
        var sb = StringBuilder()
        while (tempHead != null) {
            sb.append(tempHead.value)
            tempHead = tempHead.next
        }
        (findViewById(R.id.displayElement) as TextView).text = sb.toString()
    }

    private fun insertNodeAtMid() {
        var slowPointer = head
        var fastPointer = head?.next?.next

        while (fastPointer!!.next != null) {
            slowPointer = slowPointer!!.next
            fastPointer = fastPointer.next
        }
        Log.e("mid node is :- ", "" + slowPointer!!.value)
    }

}