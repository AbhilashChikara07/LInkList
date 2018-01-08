package com.example.chikara.linklist.DoubleLInkList

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.TextView
import com.example.chikara.linklist.R

/**
 * Created by chikara on 1/4/18.
 */

class DoubleListInsertElement : AppCompatActivity() {

    var head: NodeClass? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.link_list_layout)
        insertElement()
    }

    inner class NodeClass(tempValue: Int) {
        var value: Int? = null
        var prev: NodeClass? = null
        var next: NodeClass? = null

        init {
            this.value = tempValue
        }
    }


    private fun insertElement() {

        insertInReverseOrder(1)
        insertInReverseOrder(2)
        insertInReverseOrder(3)
        insertInReverseOrder(4)
        insertInReverseOrder(5)
        displayValue()

    }

    private fun insertInReverseOrder(tempValue: Int) {

        if (head == null) {
            head = NodeClass(tempValue)
            head!!.next = null
            head!!.prev = null
        } else {
            val tempHead = NodeClass(tempValue)
            tempHead.next = head
            tempHead.prev = null
            head = tempHead
        }

    }

    private fun displayValue() {
        val sb = StringBuilder()
        var tempNode = head
        while (tempNode != null) {
            sb.append(tempNode.value)
            tempNode = tempNode.next
        }
        (findViewById(R.id.displayElement) as TextView).text = sb.toString()
    }

}