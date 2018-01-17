package com.example.chikara.linklist.SingleLinkList

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.TextView
import com.example.chikara.linklist.R

/**
 * Created by chikara on 12/28/17.
 */
class InsertionAtBeginning : AppCompatActivity() {
    private var head: NodeClass? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.link_list_layout)
        makeList()
    }


    internal class NodeClass(tempValue: Int) {
        var next: NodeClass? = null
        var value: Int? = null

        init {
            value = tempValue
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
        var tempHead = head
        while (tempHead != null) {
            sb.append(tempHead!!.value)
            tempHead = tempHead!!.next
        }
        (findViewById<TextView>(R.id.displayElement) as TextView).text = sb.toString()
    }

    private fun insertElementAtBeginning() {
        val tempNode = NodeClass(10)
        tempNode.next = head
        head = tempNode
        displayValue()
    }
}