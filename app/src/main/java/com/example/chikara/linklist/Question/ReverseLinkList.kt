package com.example.chikara.linklist.Question

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.TextView
import com.example.chikara.linklist.R

/**
 * Created by abhilash on 16/1/18.
 */

class ReverseLinkList : AppCompatActivity() {

    var head: NodeClass? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.link_list_layout)
        makeList()
        head = reverseLinkList()
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
        for (i in 0..5) {
            insertionElement(i)
        }
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

    fun reverseLinkList(): NodeClass? {
        var tempHead = head
        var slowNode: NodeClass? = null
        var fastNode: NodeClass? = null

        while (tempHead != null) {
            fastNode = tempHead.next
            tempHead.next = slowNode
            slowNode = tempHead
            tempHead = fastNode
        }

        return slowNode
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