package com.example.chikara.linklist.Question

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.chikara.linklist.R

class InterSectionPointOfTwoShortList : AppCompatActivity() {
    var firstHead: NodeClass? = null
    var firstTempHead: NodeClass? = null

    var secondHead: NodeClass? = null
    var secondTempHead: NodeClass? = null

    var thirdHead: NodeClass? = null
    var thirdTempHead: NodeClass? = null

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

        insertionThirdHeadElement(7)
        insertionThirdHeadElement(8)
        insertionThirdHeadElement(9)

        makeFinalList()

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

    private fun insertionThirdHeadElement(tempValue: Int) {
        if (thirdHead == null) {
            thirdHead = NodeClass(tempValue)
            thirdHead!!.next = null
            thirdTempHead = thirdHead
        } else {
            val tempHead = NodeClass(tempValue)
            thirdTempHead?.next = tempHead
            thirdTempHead = tempHead
            thirdTempHead?.next = null
        }
    }

    private fun makeFinalList() {
        firstTempHead?.next = thirdHead
        secondTempHead?.next = thirdHead
    }

    /*
    * METHOD -1
    * first get length of both list.
    * (C1-C2)
    * start node with equal length.
    * */


    /*
    *
    * */
}