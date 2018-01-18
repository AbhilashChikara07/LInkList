package com.example.chikara.linklist.Question

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.TextView
import com.example.chikara.linklist.R

/**
 * Created by abhilash on 18/1/18.
 */

class MergeTwoShortList : AppCompatActivity() {
    var firstHead: NodeClass? = null
    var secondHead: NodeClass? = null
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

        insertionFirstHeadElement(9)
        insertionFirstHeadElement(7)
        insertionFirstHeadElement(5)
        insertionFirstHeadElement(2)

        insertionSecondHeadElement(8)
        insertionSecondHeadElement(6)
        insertionSecondHeadElement(4)
        insertionSecondHeadElement(3)
        insertionSecondHeadElement(1)

        finalHead = mergeLinkList()
        displayElement(finalHead!!)

    }

    private fun insertionFirstHeadElement(tempValue: Int) {
        if (firstHead == null) {
            firstHead = NodeClass(tempValue)
        } else {
            val tempHead = NodeClass(tempValue)
            tempHead.next = firstHead
            firstHead = tempHead
        }
    }

    private fun insertionSecondHeadElement(tempValue: Int) {
        if (secondHead == null) {
            secondHead = NodeClass(tempValue)
        } else {
            val tempHead = NodeClass(tempValue)
            tempHead.next = secondHead
            secondHead = tempHead
        }
    }

    private fun mergeLinkList(): NodeClass {
        var shortListHead: NodeClass? = null
        var tempHead: NodeClass? = null

        var pHead: NodeClass? = firstHead
        var qHead: NodeClass? = secondHead

        if (pHead == null)
            return qHead!!
        if (qHead == null)
            return pHead

        if (pHead.data!! <= qHead.data!!) {
            shortListHead = pHead
            pHead = pHead.next
        } else {
            shortListHead = qHead
            qHead = qHead.next
        }
        tempHead = shortListHead

        while (pHead != null && qHead != null) {
            if (pHead.data!! <= qHead.data!!) {
                shortListHead!!.next = pHead
                shortListHead = pHead
                pHead = shortListHead.next
            } else {
                shortListHead!!.next = qHead
                shortListHead = qHead
                qHead = shortListHead.next
            }
        }

        if (pHead == null) {
            shortListHead!!.next = qHead
        } else {
            shortListHead!!.next = pHead
        }

        return tempHead
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