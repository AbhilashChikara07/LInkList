package com.example.chikara.linklist.Question

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.TextView
import com.example.chikara.linklist.R

class CloneLinkedList : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.link_list_layout)

        val start = NodeClass(1)
        start.next = NodeClass(2)
        start.next!!.next = NodeClass(3)
        start.next!!.next!!.next = NodeClass(4)
        start.next!!.next!!.next!!.next = NodeClass(5)

        // 1's random points to 3
        start.random = start.next!!.next;

        // 2's random points to 1
        start.next!!.random = start;

        // 3's and 4's random points to 5
        start.next!!.next!!.random = start.next!!.next!!.next!!.next;
        start.next!!.next!!.next!!.random = start.next!!.next!!.next!!.next;

        // 5's random points to 2
        start.next!!.next!!.next!!.next!!.random = start.next;

        cloneList(start)
    }

    class NodeClass(data: Int) {
        var next: NodeClass? = null
        var random: NodeClass? = null
        var data: Int? = null

        init {
            this.data = data
            this.next = null
            this.random = null
        }

    }

    private fun cloneList(head: NodeClass?) {
        var tempHead: NodeClass? = head
        var cloneHead: NodeClass? = null
        val mHashMap = HashMap<NodeClass?, NodeClass?>()
        while (null != tempHead) {
            cloneHead = NodeClass(tempHead.data!!)
            mHashMap[tempHead] = cloneHead
            tempHead = tempHead.next
        }

        tempHead = head
        var tempNode: NodeClass? = null
        while (null != tempHead) {
            cloneHead = mHashMap[tempHead]
            cloneHead?.next = mHashMap[tempHead.next]
            cloneHead?.random = mHashMap[tempHead.random]
            tempHead = tempHead.next
            if (null == tempNode) {
                tempNode = cloneHead
            }
        }
        tempNode
    }


    private fun displayElement(mHead_1: NodeClass?) {
        val textValue = StringBuilder()
        var tempHead: NodeClass? = mHead_1
        while (tempHead != null) {
            textValue.append(tempHead.data)
            textValue.append(",")
            tempHead = tempHead.next
        }
        (findViewById<View>(R.id.displayElement) as TextView).text = textValue.toString()
    }

}