package com.example.chikara.linklist.Question

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.TextView
import com.example.chikara.linklist.R

/**
 * Created by abhilash on 14/1/18.
 */

class ShortLinkList : AppCompatActivity() {

    var head: NodeClass? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.link_list_layout)
        makeList()
        shortLinkList()
        displayElement()
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
        insertionElement(3)
        insertionElement(2)
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

    fun shortLinkList() {
        var tempHead: NodeClass? = head
        var slowNode: NodeClass? = head
        var fastNode: NodeClass? = head

        if (tempHead != null) {
            fastNode = fastNode?.next
        }

        while (tempHead?.next != null) {
            while (fastNode != null) {
                if (tempHead?.value!! < fastNode.value!!) {
                    val tempData = fastNode.value
                    fastNode.value = tempHead.value
                    tempHead.value = tempData
                    fastNode = fastNode.next
                    slowNode = slowNode?.next
                } else {
                    fastNode = fastNode.next
                    slowNode = slowNode?.next
                }
                tempHead = tempHead.next
                slowNode = tempHead
                fastNode = tempHead?.next
            }
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