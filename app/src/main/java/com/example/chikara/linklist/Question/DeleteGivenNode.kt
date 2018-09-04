package com.example.chikara.linklist.Question

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.TextView
import com.example.chikara.linklist.R

class DeleteGivenNode : AppCompatActivity() {

    var head: NodeClass? = null
    var tempHead: NodeClass? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.link_list_layout)
        makeLinkList()
        deleteGivenNode(2)
    }


    inner class NodeClass(value: Int) {

        var value: Int? = null
        var next: NodeClass? = null

        init {
            this.value = value
            this.next = null
        }
    }

    private fun makeLinkList() {
        for (i in 0..4) {
            insertValue(i)
        }
        displayValue()
    }

    private fun insertValue(value: Int) {
        if (head == null) {
            head = NodeClass(value)
            tempHead = head
        } else {
            val tempNode = NodeClass(value)
            tempHead?.next = tempNode
            tempHead = tempNode
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

    private fun deleteGivenNode(position: Int) {
        var mTempNode = head
        var mTempPosition: Int = 0

        if (mTempNode == null)
            return

        if (mTempNode.next == null)
            mTempNode = null


        while (mTempNode != null && mTempPosition + 1 == position) {
            mTempNode = mTempNode.next
            mTempPosition += 1
        }

        val nextNode = mTempNode?.next?.next
        mTempNode!!.next = nextNode

        displayValue()

    }

}