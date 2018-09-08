package com.example.chikara.linklist.Question

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.TextView
import com.example.chikara.linklist.R

class MakeLastNodeAsHead : AppCompatActivity() {

    var head: NodeClass? = null
    var tempHead: NodeClass? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.link_list_layout)
        makeList()
    }

    inner class NodeClass(var tempValue: Int) {
        var data: Int? = null
        var next: NodeClass? = null

        init {
            this.data = tempValue
            next = null
        }
    }

    fun makeList() {

        insertionElement(1)
        insertionElement(2)
        insertionElement(3)
        insertionElement(4)
        insertionElement(5)
        makeLastNodeFirst()
    }

    private fun insertionElement(tempValue: Int) {
        if (head == null) {
            head = NodeClass(tempValue)
            tempHead = head
        } else {
            val mTempHead = NodeClass(tempValue)
            this.tempHead!!.next = mTempHead
            this.tempHead = mTempHead
        }
    }

    private fun makeLastNodeFirst() {
        var mTempHead: NodeClass? = head
        val mFirstNode: NodeClass? = head
        var mLastNode: NodeClass? = null

        while (mTempHead?.next?.next != null)
            mTempHead = mTempHead?.next

        mLastNode = mTempHead
        mTempHead = mTempHead?.next
        mTempHead?.next = mFirstNode
        mLastNode?.next = null
        head = mTempHead

        displayValue()
    }

    private fun displayValue() {
        val sb = StringBuilder()
        var tempNode = head
        while (tempNode != null) {
            sb.append(tempNode.data)
            tempNode = tempNode.next
        }
        (findViewById<TextView>(R.id.displayElement) as TextView).text = sb.toString()
    }

}