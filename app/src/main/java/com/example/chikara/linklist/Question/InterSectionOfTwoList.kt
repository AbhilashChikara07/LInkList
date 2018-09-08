package com.example.chikara.linklist.Question

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.TextView
import com.example.chikara.linklist.R

class InterSectionOfTwoList : AppCompatActivity() {
    var firstHead: NodeClass? = null
    var firstTempHead: NodeClass? = null

    var secondHead: NodeClass? = null
    var secondTempHead: NodeClass? = null

    var finalHead: NodeClass? = null

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

        insertionFirstHeadElement(1)
        insertionFirstHeadElement(2)
        insertionFirstHeadElement(3)

        insertionSecondHeadElement(1)
        insertionSecondHeadElement(2)
        insertionSecondHeadElement(3)
        insertionSecondHeadElement(4)

        makeListOfAllCommonElement()
    }

    private fun insertionFirstHeadElement(tempValue: Int) {
        if (firstHead == null) {
            firstHead = NodeClass(tempValue)
            firstTempHead = firstHead
        } else {
            val tempHead = NodeClass(tempValue)
            firstTempHead?.next = tempHead
            firstTempHead = tempHead
        }
    }

    private fun insertionSecondHeadElement(tempValue: Int) {
        if (secondHead == null) {
            secondHead = NodeClass(tempValue)
            secondHead!!.next = null
            secondTempHead = secondHead
        } else {
            val tempHead = NodeClass(tempValue)
            secondTempHead?.next = tempHead
            secondTempHead = tempHead
            secondTempHead?.next = null
        }
    }


    /*
    * METHOD 1
    *
    * By traversing all element
    * */

    private fun makeListOfAllCommonElement() {

        var mFinalTempHead: NodeClass? = null
        var mFinalHead: NodeClass? = null

        var pNode = firstHead
        var qNode = secondHead

        while (pNode != null && qNode != null) {

            while (pNode != null) {

                if (pNode?.data == qNode.data) {
                    if (mFinalHead == null) {
                        mFinalHead = NodeClass(pNode.data!!)
                        mFinalHead.next = null
                        mFinalTempHead = mFinalHead
                    } else {
                        if (mFinalTempHead?.data != pNode?.data) {
                            val mTempNode = NodeClass(pNode?.data!!)
                            mFinalTempHead!!.next = mTempNode
                            mFinalTempHead = mTempNode
                            mFinalTempHead.next = null
                        }
                    }
                }
                pNode = pNode?.next

            }

            qNode = qNode.next
            pNode = firstHead

        }
        displayElement(mFinalHead!!)
    }


    /*
    * METHOD 2
    *
    * By hashing
    * */

    private fun makeListOfAllCommonElementByHashing() {
    }

    private fun displayElement(tempHead: NodeClass) {
        val textValue = StringBuilder()
        var tempHead: NodeClass? = tempHead
        while (tempHead != null) {
            textValue.append(tempHead.data)
            tempHead = tempHead.next
        }
        (findViewById<View>(R.id.displayElement) as TextView).text = textValue.toString()
    }

}