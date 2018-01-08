package com.example.chikara.linklist.DoubleLInkList

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.TextView
import com.example.chikara.linklist.R

/**
 * Created by chikara on 1/4/18.
 */

class DoubleDeleteLastNode : AppCompatActivity() {

    var head: NodeClass? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.link_list_layout)
        pushNode()
        deleteLastNodeWithTwoPointer()
//        deleteLastNode()
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

    private fun deleteLastNode() {
        var tempHead = head
        while (tempHead != null) {
            if (tempHead.next!!.next == null) {
                tempHead.next = null
                displayValue()
                break
            } else {
                tempHead = tempHead.next
            }
        }
    }

    private fun deleteLastNodeWithTwoPointer() {
        var fastPonter = head
        var slowPonter = head
        if (fastPonter == null) {
            Log.e("List Status :- ", "Make Link List")
        } else if (fastPonter.next == null) {
            Log.e("List Status :- ", "List Have only One Node")
        } else if (fastPonter!!.next!!.next == null) {
            fastPonter.next = null
            head = fastPonter
            Log.e("List Status :- ", "List Have Two Node Only")
        } else {
            fastPonter = fastPonter.next
            slowPonter = head
            while (fastPonter!!.next != null) {
                fastPonter = fastPonter.next
                slowPonter = slowPonter?.next
            }
            slowPonter!!.next = null
            displayValue()
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