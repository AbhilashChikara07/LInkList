package com.example.chikara.linklist.Question

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.TextView
import com.example.chikara.linklist.R

/**
 * Created by abhilash on 14/1/18.
 */

class RemoveShortListDuplicateElement : AppCompatActivity() {

    var head: NodeClass? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.link_list_layout)
        makeList()
        removeDuplicateElement()
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

        insertionElement(2)
        insertionElement(2)
        insertionElement(3)
        insertionElement(3)

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


    private fun removeDuplicateElement() {
        var slowNode: NodeClass? = head
        var fastNode: NodeClass? = head

        if (slowNode != null) {
            fastNode = fastNode?.next
        }
        while (slowNode?.next != null) {
            if (slowNode.value == fastNode?.value) {
                fastNode = fastNode?.next
                slowNode.next = null
                slowNode.next = fastNode
            } else {
                slowNode = slowNode.next
                fastNode = fastNode?.next
            }
        }
        displayElement()
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