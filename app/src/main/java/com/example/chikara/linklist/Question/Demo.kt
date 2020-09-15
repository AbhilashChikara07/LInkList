package com.example.chikara.linklist.Question

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import android.widget.TextView
import com.example.chikara.linklist.R
import java.util.*
import kotlin.collections.ArrayList

/*
* Rearrange a given list such that it consists of alternating minimum maximum elements
* */
class Demo : AppCompatActivity() {
    private var head: NodeClass? = null
    private var tempHead: NodeClass? = null
    private var mStack = Stack<Int>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.link_list_layout)

        createNode(1)
        createNode(2)
        createNode(3)
        createNode(4)
        createNode(5)
        createNode(6)
        createNode(7)
        createNode(8)
        createNode(9)

        reArrangeMethodTwo()
//        reArrange()
    }

    class NodeClass(data: Int) {
        var next: NodeClass? = null
        var data: Int? = null

        init {
            this.data = data
            this.next = null
        }
    }

    private fun createNode(data: Int) {
        if (null == head) {
            head = NodeClass(data)
            tempHead = head
        } else {
            val mTempNode = NodeClass(data)
            tempHead!!.next = mTempNode
            tempHead = mTempNode
        }
    }

    private fun reArrangeMethodTwo() {
        val list = LinkedList<Int>()
        var tempHead = head

        while (null != tempHead) {
            list.add(tempHead.data!!)
            tempHead = tempHead.next
        }

        for (i in 1 until list.size / 2 + 1) {
            val x = list.last
            list.removeLast()
            list.add(2 * i - 1, x)
        }

        list
    }

    private fun mergeTwoList(): NodeClass? {
        var pHead: NodeClass? = null
        var qhead: NodeClass? = null
        var even = false

        if (null == pHead)
            return qhead
        if (null == qhead)
            return pHead

        var head: NodeClass? = null
        var tempHead = head

        if (null == head) {
            head = pHead
            tempHead = head
            pHead = pHead.next
        }


        while (null != pHead && null != qhead) {
            if (even) {
                tempHead!!.next = qhead
                qhead = qhead.next
            } else {
                tempHead!!.next = pHead
                pHead = pHead.next
            }
            tempHead = tempHead.next
        }

        if (null == pHead)
            tempHead!!.next = qhead
        if (null == qhead)
            tempHead!!.next = pHead

        return head
    }

    private fun reArrange() {
        var tempHead = head
        val list = ArrayList<Int>()
        var mHead: NodeClass? = null
        var position = 0
        var event = false
        var loopCount = 0

        while (null != tempHead) {
            list.add(tempHead.data!!)
            mStack.push(tempHead.data!!)
            tempHead = tempHead.next
        }
        tempHead = mHead

        if (null == mHead) {
            mHead = NodeClass(list[position])
            tempHead = mHead
            position += 1
        }


        while (loopCount < (mStack.size / 2 + 1)) {
            if (!event) {
                tempHead!!.next = NodeClass(mStack.pop())
                tempHead = tempHead.next
                loopCount += 1
            } else {
                tempHead!!.next = NodeClass(list[position])
                tempHead = tempHead.next
                position += 1
            }
            event = !event
        }
        tempHead!!.next = NodeClass(list[position])
        if (list.size % 2 == 0)
            tempHead.next!!.next = NodeClass(list[position + 1])

        displayElement(mHead)
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