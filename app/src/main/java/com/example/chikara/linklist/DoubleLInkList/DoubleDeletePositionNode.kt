package com.example.chikara.linklist.DoubleLInkList

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.TextView
import com.example.chikara.linklist.R

/**
 * Created by chikara on 1/4/18.
 */

class DoubleDeletePositionNode : AppCompatActivity() {

    var head: NodeClass? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.link_list_layout)
        pushNode()
        deleteMidNode()
//        deletePositionNode(3)
//        displayValue()
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

    private fun deletePositionNode(position: Int) {
        val tempHead = head
        var count: Int? = 0
        while (tempHead != null) {
            if (position == count!! + 1) {
                if (tempHead.next!!.next != null) {
                    tempHead.next = tempHead.next!!.next!!.prev
                } else {
                    tempHead.next = null
                }
                displayValue()
                break
            } else {
                count += 1
            }
        }
    }

    private fun deleteMidNode() {
        var slowPointer = head
        var fastPointer = head
        when {
            fastPointer == null -> Log.e("Node Status :- ", "Link List is empty")
            fastPointer.next == null -> Log.e("Node Status :- ", "Link List have only one node")
            fastPointer.next?.next == null -> {
                fastPointer.next = null
                Log.e("Node Status :- ", "Node has been deleted")
            }
            else -> {
                fastPointer = fastPointer.next?.next
                while (fastPointer?.next != null) {
                    slowPointer = slowPointer?.next
                    fastPointer = fastPointer?.next
                }
                slowPointer?.next = slowPointer?.next?.next
                displayValue()
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