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
        for (i in 0..9) {
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
        val sb = StringBuilder()
        while (tempHead != null) {
            sb.append(tempHead.value)
            sb.append(",")
            tempHead = tempHead.next
        }
        (findViewById(R.id.displayElement) as TextView).text = sb.toString()
    }

    private fun insertNodeAtMid() {
        var slow_ptr = head
        var fast_ptr = head
        if (head != null) {
            while (fast_ptr != null && fast_ptr.next != null) {
                fast_ptr = fast_ptr!!.next!!.next
                slow_ptr = slow_ptr?.next
            }
            Log.e("mid node is :- ", "" + slow_ptr?.value)

        }
    }

}