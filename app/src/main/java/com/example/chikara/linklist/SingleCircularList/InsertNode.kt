package com.example.chikara.linklist.SingleCircularList

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.TextView
import com.example.chikara.linklist.R

/**
 * Created by chikara on 1/8/18.
 */

class InsertNode : AppCompatActivity() {

    var head: NodeClass? = null
    var lastNode: NodeClass? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.link_list_layout)
        push()
        displayAllNode()
    }

    inner class NodeClass(tempValue: Int) {
        var value: Int? = null
        var next: NodeClass? = null

        init {
            this.value = tempValue
            this.next = null
        }
    }

    fun push() {
        for (i in 0..5) {
            insertElement(i)
        }
    }

    private fun insertElement(tempValue: Int) {
        if (head == null) {
            head = NodeClass(tempValue)
            lastNode = head
            lastNode?.next = head
        } else {
            val tempHead = NodeClass(tempValue)
            tempHead.next = head
            head = tempHead
            lastNode?.next = head
        }
    }

    fun displayAllNode() {
        var tempHead = head
        val sb = StringBuilder()
        while (tempHead != lastNode) {
            sb.append(tempHead?.value)
            tempHead = tempHead?.next
        }
        sb.append(tempHead?.value)
        (findViewById(R.id.displayElement) as TextView).text = sb.toString()
    }
}