package com.example.chikara.linklist.Question

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.TextView
import com.example.chikara.linklist.R

class SeparateEvenAndOddNode : AppCompatActivity() {


    var head: NodeClass? = null
    var tempHead: NodeClass? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.link_list_layout)

        makeLinkList()

    }

    class NodeClass(value: Int) {

        var value: Int? = null
        var next: NodeClass? = null

        init {
            this.value = value
            next = null
        }

    }

    private fun makeLinkList() {
        insertValue(2)
        insertValue(1)
        insertValue(2)
        insertValue(3)
        insertValue(4)
        insertValue(5)

        /*
        * METHOD -1
        * */
        separateEvenOdd(head!!)

        /*
        * METHOD -2
        * we can achieve this by storing element in two separated array.
        * One array is for Even.
        * Second array is for Odd
        * */

    }

    private fun insertValue(value: Int) {
        if (head == null) {
            head = NodeClass(value)
            tempHead = head
        } else {
            val mTempNode = NodeClass(value)
            tempHead?.next = mTempNode
            tempHead = mTempNode
        }
    }

    private fun separateEvenOdd(mTempHeadNode: NodeClass) {
        val mTempHead: NodeClass = mTempHeadNode

        var mEvenHead: NodeClass? = null
        var mEvenLastNode: NodeClass? = null
        var mOddHead: NodeClass? = null
        var mOddLastNode: NodeClass? = null


        if ((mTempHead.value)!! % 2 == 0) {
            mOddHead = getNextOddNode(mTempHead)
            mOddLastNode = mOddHead

            mEvenHead = mTempHead
            mEvenLastNode = mEvenHead

            while (mEvenLastNode!!.next != mOddHead)
                mEvenLastNode = mEvenLastNode.next

            mEvenLastNode.next = null

            while (mOddLastNode?.next != null) {
                if ((mOddLastNode.next?.value)!! % 2 == 0) {
                    mEvenLastNode?.next = mOddLastNode.next
                    mEvenLastNode = mEvenLastNode?.next

                    mOddLastNode.next = mOddLastNode.next?.next
                    mOddLastNode = mOddLastNode.next

                } else
                    mOddLastNode = mOddLastNode.next
            }

            mEvenLastNode?.next = mOddHead

            displayElement(mEvenHead)

        } else if ((mTempHead.value)!! % 2 == 1) {
            mEvenHead = getNextEvenNode(mTempHead)
            mEvenLastNode = mEvenHead

            mOddHead = mTempHead
            mOddLastNode = mOddHead

            while (mOddLastNode!!.next != mEvenHead)
                mOddLastNode = mOddLastNode.next

            mOddLastNode.next = null


            displayElement(mOddHead)

        }


    }

    private fun getNextOddNode(mTempHeadNode: NodeClass): NodeClass {

        var mTempHead = mTempHeadNode

        while ((mTempHead.value)!! % 2 != 1) {
            mTempHead = mTempHead.next!!
        }

        return mTempHead
    }

    private fun getNextEvenNode(mTempHeadNode: NodeClass): NodeClass {

        var mTempHead = mTempHeadNode

        while ((mTempHead.value)!! % 2 != 0) {
            mTempHead = mTempHead.next!!
        }

        return mTempHead
    }


    private fun separateEvenOddMethod_2() {

    }

    private fun displayElement(mTempHead: NodeClass) {
        val textValue = StringBuilder()
        var tempHead: NodeClass? = mTempHead
        while (tempHead != null) {
            textValue.append(tempHead.value)
            tempHead = tempHead.next
        }
        (findViewById<View>(R.id.displayElement) as TextView).text = textValue.toString()
    }

}