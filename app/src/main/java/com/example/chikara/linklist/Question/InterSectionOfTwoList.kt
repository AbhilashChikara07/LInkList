package com.example.chikara.linklist.Question

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.TextView
import com.example.chikara.linklist.R

class InterSectionOfTwoList : AppCompatActivity() {
    private var mHead_1: NodeClass? = null
    private var mTempHead_1: NodeClass? = null

    private var mHead_2: NodeClass? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.link_list_layout)

        createNode(1, false)
        createNode(2, false)
        createNode(3, false)
        createNode(4, true)
        createNode(5, false)
        createNode(6, false)

        intersectionOfLinkedList()

    }

    class NodeClass(value: Int) {
        var mNext: NodeClass? = null
        var mValue: Int? = null

        init {
            this.mValue = value
            this.mNext = null
        }
    }

    private fun createNode(value: Int, flag: Boolean) {
        if (null == mHead_1) {
            mHead_1 = NodeClass(value)
            mHead_1!!.mNext = null
            mTempHead_1 = mHead_1
        } else {
            val mTempNode = NodeClass(value)
            mTempHead_1!!.mNext = mTempNode
            mTempHead_1 = mTempNode
            if (flag) {
                mHead_2 = mTempHead_1
            }
        }
    }

    private fun intersectionOfLinkedList() {
        val mFirstCount = getCount(mHead_1)
        val mSecondCount = getCount(mHead_2)
        var mDiff: Int = 0

        var tempFirstNode: NodeClass? = mHead_1
        var tempSecondNode: NodeClass? = mHead_2

        if (mFirstCount > mSecondCount) {
            mDiff = mFirstCount - mSecondCount
            var count = 0
            while (count != mDiff) {
                count += 1
                tempFirstNode = tempFirstNode?.mNext
            }
        } else {
            mDiff = mSecondCount - mFirstCount
            var count = 0
            while (count != mDiff) {
                count += 1
                tempSecondNode = tempSecondNode?.mNext
            }
        }

        while (tempFirstNode != tempSecondNode) {
            tempFirstNode = tempFirstNode?.mNext
            tempSecondNode = tempSecondNode?.mNext
        }

        tempFirstNode
        tempSecondNode

    }

    private fun getCount(mHead: NodeClass?): Int {
        var mTempHead = mHead
        var mCount = 0
        while (null != mTempHead) {
            mCount += 1
            mTempHead = mTempHead.mNext
        }

        return mCount
    }


}