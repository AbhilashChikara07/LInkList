package com.example.chikara.linklist.Question

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.TextView
import com.example.chikara.linklist.R
import java.util.*

class ReverseAlternateNodeInGroup : AppCompatActivity() {

    private var head: NodeClass? = null
    private var tempHead: NodeClass? = null
    private var mStack: Stack<Int> = Stack()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.link_list_layout)

        createNode(1)
        createNode(2)
        createNode(3)
        createNode(4)
        createNode(5)
        createNode(6)

        reverseInGroup(2)
    }

    class NodeClass(value: Int) {
        var next: NodeClass? = null
        var value: Int = 0

        init {
            this.value = value
            this.next = null
        }
    }

    private fun createNode(value: Int) {
        if (null == head) {
            head = NodeClass(value)
            tempHead = head
        } else {
            val node = NodeClass(value)
            tempHead?.next = node
            tempHead = tempHead!!.next
        }
    }

    private fun reverseInGroup(group: Int) {
        var current = head
        var mHead: NodeClass? = null
        var mTempHead: NodeClass? = null
        var count = 0

        while (null != current) {
            while (count != group && null != current) {
                count += 1
                mStack.push(current.value)
                current = current.next
            }
            count = 0

            while (!mStack.isEmpty()) {
                if (null == mHead) {
                    mHead = NodeClass(mStack.pop())
                    mTempHead = mHead
                } else {
                    val node = NodeClass(mStack.pop())
                    mTempHead!!.next = node
                    mTempHead = mTempHead.next
                }
            }

            while (count != group && null != current) {
                count += 1
                val node = NodeClass(current.value)
                mTempHead?.next = node
                current = current.next
                mTempHead = mTempHead?.next
            }
            count = 0
        }

        displayElement(mHead)
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