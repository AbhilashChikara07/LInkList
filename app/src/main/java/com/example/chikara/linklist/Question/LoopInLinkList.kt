package com.example.chikara.linklist.Question

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import android.widget.TextView
import com.example.chikara.linklist.R

/**
 * Created by abhilash on 12/1/18.
 */

class LoopInLinkList : AppCompatActivity() {

    var head: NodeClass? = null
    var lastHead: NodeClass? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.link_list_layout)
        makeList()
        findLoopInLinkList()
    }

    inner class NodeClass(var tempValue: Int) {
        var value: Int? = null
        var next: NodeClass? = null

        init {
            this.value = tempValue
            next = null
        }
    }

    fun makeList() {
        for (i in 0..5) {
            insertionElement(i)
        }
    }

    private fun insertionElement(tempValue: Int) {
        if (head == null) {
            head = NodeClass(tempValue)
            lastHead = head
        } else {
            val tempHead = NodeClass(tempValue)
            tempHead.next = head
            head = tempHead
            if (tempValue == 5) {
                lastHead?.next = tempHead.next?.next
            }
        }
    }

    private fun findLoopInLinkList() {
        var fastNode = head
        var slowNode = head

        while (fastNode != null && slowNode != null) {
            fastNode = fastNode.next?.next
            slowNode = slowNode.next

            if (slowNode == fastNode) {
                Log.e("Loop status :- ", "Loop in link list")
                removeLoop(slowNode!!)
                break
            }
        }
    }

    private fun removeLoop(slowNode: NodeClass) {
        var slowOne: NodeClass? = slowNode
        val slowTwo: NodeClass? = slowNode
        while (slowOne?.next != slowNode) {
            slowOne = slowOne?.next
        }
        while (slowTwo?.next != slowOne) {
            slowTwo?.next = null
            displayElement()
            break
        }
    }

    private fun displayElement() {
        val textValue = StringBuilder()
        var tempHead: NodeClass? = head
        while (tempHead != null) {
            textValue.append(tempHead.value)
            tempHead = tempHead.next
        }
        (findViewById<View>(R.id.displayElement) as TextView).text = textValue.toString()
    }

}