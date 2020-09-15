package com.example.chikara.linklist.Question

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.TextView
import com.example.chikara.linklist.R
import java.util.*

/**
 * By using stack we can solve this problem.
 * */
class ReverseLinkListInGroup : AppCompatActivity() {

    var head: NodeClass? = null
    var tempHead: NodeClass? = null
    var mStack: Stack<Int> = Stack()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.link_list_layout)

        createNode(1)
        createNode(2)
        createNode(3)
        createNode(4)
        createNode(5)
        createNode(6)

        val ss = reverseInGroup(2)
        displayElement(ss)
    }

    private fun createNode(value: Int) {
        if (null == head) {
            head = NodeClass(value)
            head!!.mNext = null
            tempHead = head
        } else {
            val mTempNode = NodeClass(value)
            tempHead!!.mNext = mTempNode
            tempHead = mTempNode
        }
    }

    class NodeClass(value: Int) {
        var mNext: NodeClass? = null
        var mValue: Int? = null

        init {
            this.mValue = value
            this.mNext = null
        }
    }


    private fun reverseInGroup(group: Int): NodeClass? {
        var count = 0
        var current = head
        var mHead: NodeClass? = null
        var mTempHead: NodeClass? = null
        while (null != current) {
            while (count != group) {
                count += 1
                mStack.push(current?.mValue)
                current = current?.mNext
            }
            count = 0
            while (mStack.size > 0) {
                if (null == mHead) {
                    mHead = NodeClass(mStack.pop())
                    mTempHead = mHead
                } else {
                    val mTempNode = NodeClass(mStack.pop())
                    mTempHead?.mNext = mTempNode
                    mTempHead = mTempHead?.mNext
                }
            }
        }
        return mHead
    }

    private fun displayElement(mHead_1: NodeClass?) {
        val textValue = StringBuilder()
        var tempHead: NodeClass? = mHead_1
        while (tempHead != null) {
            textValue.append(tempHead.mValue)
            tempHead = tempHead.mNext
        }
        (findViewById<View>(R.id.displayElement) as TextView).text = textValue.toString()
    }

}