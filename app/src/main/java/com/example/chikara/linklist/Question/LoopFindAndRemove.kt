package com.example.chikara.linklist.Question

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import android.widget.TextView
import com.example.chikara.linklist.R

/**
 * Created by abhilash on 12/1/18.
 */

class LoopFindAndRemove : AppCompatActivity() {

    var head: NodeClass? = null
    var tempHead: NodeClass? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.link_list_layout)
        makeList()
        findLoopInLinkList()
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
            tempHead = head
        } else {
            val tempHead = NodeClass(tempValue)
            this.tempHead!!.next = tempHead
            tempHead.next = this.tempHead
            this.tempHead = tempHead

        }
    }

    private fun findLoopInLinkList() {
        var fastNode: NodeClass? = head
        var slowNode: NodeClass? = head

        while (fastNode != null && slowNode != null) {
            fastNode = fastNode?.next?.next
            slowNode = slowNode?.next

            if (slowNode == fastNode) {
                Log.e("Loop status :- ", "Loop in link list")
                removeLoop(slowNode!!)
                break
            }
        }
    }

    private fun removeLoop(slowNode: NodeClass) {
        var mTempSlowNode = slowNode
        var mTempFastNode = slowNode
        var mTempHead = head

        while (mTempHead != mTempSlowNode) {
            mTempFastNode = mTempSlowNode
            mTempHead = mTempHead?.next
            mTempSlowNode = mTempSlowNode.next!!
        }

        mTempFastNode.next = null
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