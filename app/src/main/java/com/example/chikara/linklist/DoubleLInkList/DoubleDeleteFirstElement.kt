package com.example.chikara.linklist.DoubleLInkList

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.TextView
import com.example.chikara.linklist.R

/**
 * Created by chikara on 1/4/18.
 */

class DoubleDeleteFirstElement : AppCompatActivity() {

    var head: NodeClass? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.link_list_layout)
        pushNode()
        deleteFirstNode()
        displayValue()
    }

    class NodeClass(tempValue: Int) {
        var value: Int? = null
        var prev: NodeClass? = null
        var next: NodeClass? = null

        init {
            this.value = tempValue
        }

    }

    private fun pushNode() {
        for (i in 0..5) {
            insertElement(i)
        }
    }

    private fun insertElement(value: Int) {
        if (head == null) {
            head = NodeClass(value)
            head!!.next = null
            head!!.prev = null
        } else {
            val tempNode = NodeClass(value)
            tempNode.next = head
            tempNode.prev = null
            head = tempNode
        }
    }

    private fun deleteFirstNode() {
        val tempHead = head
        head = tempHead!!.next
        tempHead.next = null
        displayValue()
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