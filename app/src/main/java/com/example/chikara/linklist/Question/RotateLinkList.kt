package com.example.chikara.linklist.Question

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.TextView
import com.example.chikara.linklist.R

/**
 * Created by abhilash on 19/1/18.
 */

class RotateLinkList : AppCompatActivity() {

    var head: NodeClass? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.link_list_layout)
        makeList()
        rotateLinkListFromKNode(4)
        displayElement(head!!)
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
        insertionElement(1)
        insertionElement(2)
        insertionElement(3)
        insertionElement(4)
        insertionElement(3)
        insertionElement(2)
        insertionElement(1)
    }

    private fun insertionElement(tempValue: Int) {
        if (head == null) {
            head = NodeClass(tempValue)
        } else {
            val tempHead = NodeClass(tempValue)
            tempHead.next = head
            head = tempHead
        }
    }

    fun rotateLinkListFromKNode(kNodeValue: Int) {
        var tempHead: NodeClass? = null
        var tempNode = head
        var tempLastNode: NodeClass? = null

        while (tempNode!!.value != kNodeValue) {
            tempNode = tempNode.next
        }

        tempLastNode = tempNode

        while (tempNode!!.next != null) {
            tempNode = tempNode.next
        }

        tempNode.next = head
        tempHead = tempLastNode.next
        head = tempHead
        tempLastNode.next = null
    }

    private fun displayElement(tempHead: NodeClass) {
        val textValue = StringBuilder()
        var tempHead: NodeClass? = tempHead
        while (tempHead != null) {
            textValue.append(tempHead.value)
            tempHead = tempHead.next
        }
        (findViewById<View>(R.id.displayElement) as TextView).text = textValue.toString()
    }
}
