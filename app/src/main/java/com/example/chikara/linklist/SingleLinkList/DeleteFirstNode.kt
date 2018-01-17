package com.example.chikara.linklist.SingleLinkList

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.TextView
import com.example.chikara.linklist.R

/**
 * Created by chikara on 12/29/17.
 */
class DeleteFirstNode : AppCompatActivity() {

    private var head: NodeClass? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.link_list_layout)
        makeList()
        deleteFirstNode()
        displayValue()
    }

    inner class NodeClass(tempValue: Int) {
        var next: NodeClass? = null
        var value: Int? = null

        init {
            this.value = tempValue
            next = null
        }
    }

    private fun makeList() {
        for (i in 0..4) {
            insertionElement(i)
        }
    }

    private fun insertionElement(value: Int) {
        if (head == null) {
            head = NodeClass(value)
        } else {
            val tempNode = NodeClass(value)
            tempNode.next = head
            head = tempNode
        }
        displayValue()
    }

    private fun deleteFirstNode() {
        val tempHead = head
        if (tempHead == null) {
            head = NodeClass(1)
        } else {
            if (tempHead.next != null) {
                head = tempHead.next
                tempHead.next = null
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
        (findViewById<TextView>(R.id.displayElement) as TextView).text = sb.toString()
    }

}