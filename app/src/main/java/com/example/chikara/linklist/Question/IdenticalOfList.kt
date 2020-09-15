package com.example.chikara.linklist.Question

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.TextView
import com.example.chikara.linklist.R

class IdenticalOfList : AppCompatActivity() {

    private var head_1: NodeClass? = null
    private var tempHead_1: NodeClass? = null
    private var head_2: NodeClass? = null
    private var tempHead_2: NodeClass? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.link_list_layout)

        createNode_1(1)
        createNode_1(2)
        createNode_1(3)

        createNode_2(1)
        createNode_2(2)
        createNode_2(3)

        val flag = isIdenticalOrNot()

        (findViewById<View>(R.id.displayElement) as TextView).text = flag.toString()
    }

    class NodeClass(value: Int) {
        var next: NodeClass? = null
        var value: Int = 0

        init {
            this.value = value
            this.next = null
        }
    }

    private fun createNode_1(value: Int) {
        if (null == head_1) {
            head_1 = NodeClass(value)
            tempHead_1 = head_1
        } else {
            val node = NodeClass(value)
            tempHead_1?.next = node
            tempHead_1 = tempHead_1!!.next
        }
    }

    private fun createNode_2(value: Int) {
        if (null == head_2) {
            head_2 = NodeClass(value)
            tempHead_2 = head_2
        } else {
            val node = NodeClass(value)
            tempHead_2?.next = node
            tempHead_2 = tempHead_2!!.next
        }
    }

    private fun isIdenticalOrNot(): Boolean {
        var prev_1 = head_1!!.value
        var prev_2 = head_1!!.value
        head_1 = head_1!!.next
        head_2 = head_2!!.next

        while (null != head_1 && null != head_2) {
            if (prev_1 == prev_2 && prev_1 < head_1!!.value && prev_2 < head_2!!.value) {
                prev_1 = head_1!!.value
                prev_2 = head_2!!.value
                head_1 = head_1!!.next
                head_2 = head_2!!.next
            } else return false
        }

        if (null == head_1 && null != head_2)
            return false
        if (null == head_2 && null != head_1)
            return false

        return true
    }

    private fun displayElement(mHead: NodeClass?) {
        val textValue = StringBuilder()
        var tempHead: NodeClass? = mHead
        while (tempHead != null) {
            textValue.append(tempHead.value)
            tempHead = tempHead.next
        }
        (findViewById<View>(R.id.displayElement) as TextView).text = textValue.toString()
    }

}