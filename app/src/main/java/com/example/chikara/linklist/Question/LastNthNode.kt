package com.example.chikara.linklist.Question

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.example.chikara.linklist.R

class LastNthNode : AppCompatActivity() {


    var head: NodeClass? = null
    var tempHead: NodeClass? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.link_list_layout)
        makeLinkList()
        getLastNthNode(2)
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
        for (i in 0..4) {
            insertValue(i)
        }
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

    private fun getLastNthNode(mNthNode: Int) {

        var mLengthCount: Int = 0
        var mActualNo: Int = 0
        var mTempHead = head

        while (mTempHead != null) {
            mTempHead = mTempHead.next
            mLengthCount += 1
        }

        if (mNthNode < mLengthCount)
            mActualNo = mLengthCount - mNthNode

        mTempHead = head

        for (i in 0..mActualNo) {
            if (i == mActualNo)
                Log.e("Last Nth Node is :- ", "" + mActualNo)
            mTempHead = mTempHead?.next
        }

    }

}