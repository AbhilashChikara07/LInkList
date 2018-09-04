package com.example.chikara.linklist.Question

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.TextView
import com.example.chikara.linklist.R

class LengthOfLinkListByRecursiveAndNormal : AppCompatActivity() {


    var head: NodeClass? = null
    var tempHead: NodeClass? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.link_list_layout)
        makeLinkList()
        lengthOfLinkListByNormal()

        findViewById<TextView>(R.id.displayElement).text = "" + getLengthByRecursive(head!!)
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

    private fun lengthOfLinkListByNormal(): Int {
        var mTempHead = head
        var mLengthCount = 0

        while (mTempHead != null) {
            mLengthCount += 1
            mTempHead = mTempHead.next
        }
        Log.e("count", "" + mLengthCount)
        return mLengthCount
    }

    private fun getLengthByRecursive(mTempHead: NodeClass): Int? {
        return if (mTempHead.next == null)
            1
        else
            1 + getLengthByRecursive(mTempHead.next!!)!!

    }

}