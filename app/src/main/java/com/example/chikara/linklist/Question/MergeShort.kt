package com.example.chikara.linklist.Question

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import android.widget.TextView
import com.example.chikara.linklist.R

class MergeShort : AppCompatActivity() {
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

    private fun makeList() {

        insertionElement(9)
        insertionElement(5)
        insertionElement(2)
        insertionElement(7)
        insertionElement(1)

        val mTempHead = mergeShortAlgo(head)
        displayElement(mTempHead)
    }

    private fun insertionElement(tempValue: Int) {
        if (head == null) {
            head = NodeClass(tempValue)
            tempHead = head
        } else {
            val tempHead = NodeClass(tempValue)
            this.tempHead?.next = tempHead
            this.tempHead = tempHead
        }
    }

    private fun mergeShortAlgo(mList: NodeClass?): NodeClass {

        displayElement(mList)

        var mTempList = mList

        if (mTempList?.next == null)
            return mTempList!!

        val mFirstList: NodeClass? = mTempList
        var mSecondList: NodeClass? = mTempList.next

        while (mSecondList?.next != null) {
            mTempList = mTempList!!.next!!
            mSecondList = mSecondList.next?.next
        }

        mSecondList = mTempList?.next
        mTempList?.next = null

        return mergeShort(mergeShortAlgo(mFirstList), mergeShortAlgo(mSecondList))!!
    }

    private fun mergeShort(pHead: NodeClass?, qHead: NodeClass?): NodeClass? {

//        displayElement(pHead)
//        displayElement(qHead)

        var pHead = pHead
        var qHead = qHead
        var shortListHead: NodeClass? = null
        var shortList: NodeClass? = null

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
        shortList = shortListHead

        while (pHead != null && qHead != null) {
            if (pHead.data!! <= qHead.data!!) {
                shortList!!.next = pHead
                shortList = pHead
                pHead = pHead.next
            } else {
                shortList!!.next = qHead
                shortList = qHead
                qHead = qHead.next
            }
        }

        if (pHead == null) {
            shortList!!.next = qHead
        } else {
            shortList!!.next = pHead
        }

        return shortListHead
    }

    private fun displayElement(tempHead: NodeClass?) {
        val textValue = StringBuilder()
        var tempHead: NodeClass? = tempHead
        while (tempHead != null) {
            textValue.append(tempHead.data)
            tempHead = tempHead.next
        }
        Log.e("LIST IS :- ", ""+textValue.toString())
        (findViewById<View>(R.id.displayElement) as TextView).text = textValue.toString()
    }

}