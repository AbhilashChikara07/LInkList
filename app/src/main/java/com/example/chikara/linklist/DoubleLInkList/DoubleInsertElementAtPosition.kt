package com.example.chikara.linklist.DoubleLInkList

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.TextView
import com.example.chikara.linklist.R

/**
 * Created by chikara on 1/4/18.
 */

class DoubleInsertElementAtPosition : AppCompatActivity() {

    var head: NodeClass? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.link_list_layout)
        pushData()
        insertNodeAtPosition(2)
    }

    class NodeClass(tempValue: Int) {
        var value: Int? = null
        var prev: NodeClass? = null
        var next: NodeClass? = null

        init {
            this.value = tempValue
        }

    }

    private fun pushData() {
        for (i in 0..5) {
            insertElement(i)
        }
        displayValue()
    }

    private fun insertElement(value: Int) {
        if (head == null) {
            head = NodeClass(value)
            head!!.next = null
            head!!.prev = null
        } else {
            var tempHead = NodeClass(value)
            tempHead.next = head
            tempHead.prev = null
            head = tempHead
        }
    }

    private fun insertNodeAtPosition(position: Int) {
        var tempHead = head
        var count = 0
        while (tempHead != null) {
            if (position == count + 1) {
                val tempNode = NodeClass(99)
                tempNode.next = tempHead.next
                tempNode.prev = tempHead
                tempHead.next = tempNode
                displayValue()
                break
            } else {
                count += 1
                tempHead = tempHead.next
            }
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

}