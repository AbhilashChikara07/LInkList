package com.example.chikara.linklist.DoubleLInkList

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.TextView
import com.example.chikara.linklist.R

/**
 * Created by chikara on 1/4/18.
 */

class DoubleListInsertAtEnd : AppCompatActivity() {

    var head: NodeClass? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.link_list_layout)
        makeLinkList()
    }

    inner class NodeClass(tempValue: Int) {

        var value: Int? = null
        var prev: NodeClass? = null
        var next: NodeClass? = null

        init {
            this.value = tempValue
        }

    }

    private fun makeLinkList() {
        for (i in 0..5) {
            insertElement(i)
        }
//        displayValue()
        insertNodeAtEnd(31)
    }

    private fun insertElement(tempValue: Int) {
        if (head == null) {
            head = NodeClass(tempValue)
            head!!.prev = null
            head!!.next = null
        } else {
            val tempHead = NodeClass(tempValue)
            tempHead.next = head
            tempHead.prev = null
            head = tempHead
        }
    }

    private fun insertNodeAtEnd(tempValue: Int) {
        var tempHead = head
        while (tempHead != null) {
            if (tempHead.next == null) {
                val tempNode = NodeClass(tempValue)
                tempNode.next = null
                tempHead.next = tempNode
                tempNode.prev = tempHead.next
                displayValue()
                break
            } else {
                tempHead = tempHead.next
            }
        }
    }

    private fun displayValue() {
        val sb = StringBuilder()
        var tempNode = head
        while (tempNode != null) {
            sb.append(tempNode.value)
            tempNode = tempNode.next
        }
        (findViewById(R.id.displayElement) as TextView).text = sb.toString()
    }

}