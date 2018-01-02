package com.example.chikara.linklist

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.TextView

/**
 * Created by chikara on 12/29/17.
 */
class InsertNodeAtMiddle : AppCompatActivity() {

    var head: NodeClass? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.link_list_layout)
        insertionElement()
        insertElementAtMid()
    }

    inner class NodeClass(tempValue: Int) {
        var next: NodeClass? = null
        var value: Int? = null

        init {
            this.value = tempValue
            next = null
        }
    }

    private fun insertionElement() {
        if (head != null)
            head = null
        head = NodeClass(1)
        head!!.next = NodeClass(2)
        head!!.next!!.next = NodeClass(3)
        head!!.next!!.next!!.next = NodeClass(4)
        head!!.next!!.next!!.next!!.next = NodeClass(5)
    }

    private fun insertElementAtMid() {
        val tempNode = head
        var position = 0
        val totalCount = getTotalElementCount()
        while (tempNode != null) {
            if (position != totalCount / 2) {
                var midNode = NodeClass(10)
                midNode.next = tempNode.next
                tempNode.next = midNode
                displayValue()
                break
            } else {
                position++
            }
        }
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

    private fun getTotalElementCount(): Int {
        val tempNode = head
        var count: Int = 0
        while (tempNode != null) {
            count++
        }
        return count
    }

}