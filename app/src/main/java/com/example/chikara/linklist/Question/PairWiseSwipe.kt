package com.example.chikara.linklist.Question

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.TextView
import com.example.chikara.linklist.R

class PairWiseSwipe : AppCompatActivity() {

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
        insertionElement(6)

//        swipePairWiseElement()
        swipeElementOnDff(head, 2)
        head = swipeAfterDiff()
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


    private fun swipePairWiseElement() {
        var mTempHead = head
        while (mTempHead?.next != null) {
            val k = mTempHead.data
            mTempHead.data = mTempHead?.next?.data
            mTempHead?.next?.data = k
            mTempHead = mTempHead.next?.next
        }

        displayValue()
    }


    /*
    * Swipe element after difference of TWO.
    * */

    private fun swipeElementOnDff(mTempNode: NodeClass?, mDiffValue: Int) {

        var mTempNode: NodeClass? = mTempNode
        var mTempDiffValue = 0

        while (mTempNode?.next != null) {

            while (mTempDiffValue != mDiffValue) {
                mTempNode = mTempNode?.next
                mTempDiffValue += 1
            }

            if (mTempNode != null) {
                val x = mTempNode.data
                mTempNode.data = mTempNode.next!!.data
                mTempNode.next!!.data = x

                mTempDiffValue = 0
            }
        }

        displayValue()

    }


    private fun swipeAfterDiff(): NodeClass? {
        var current = head
        var slow: NodeClass? = null
        var fast: NodeClass? = null

        while (current != null) {
            fast = current.next
            current.next = slow
            slow = current
            current = fast!!
        }
        return slow
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