package com.example.chikara.linklist.SingleLinkList

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.TextView
import com.example.chikara.linklist.R

/**
 * Created by chikara on 12/29/17.
 */
class LinkListInsertNodeAtEnd : AppCompatActivity() {

    var head: NodeClass? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.link_list_layout)
        makeList()
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

    private fun displayValue() {
        val sb = StringBuilder()
        var tempNode = head
        while (tempNode != null) {
            sb.append(tempNode.value)
            tempNode = tempNode.next
        }
        (findViewById<TextView>(R.id.displayElement) as TextView).text = sb.toString()
    }

    private fun insertElementAtEnd() {
        var tempNode = head
        while (tempNode != null) {
            if (tempNode.next == null) {
                val lastNode = NodeClass(12)
                tempNode.next = lastNode
                displayValue()

            } else {
                tempNode = tempNode.next
            }
        }
    }
}