package com.example.chikara.linklist.Question

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import android.widget.TextView
import com.example.chikara.linklist.R

class LruImplementation : AppCompatActivity() {

    private var mHashMap: HashMap<Int, NodeClass>? = HashMap()
    private var mLimit: Int = 4

    private var mHead: NodeClass? = null
    private var mLastHead: NodeClass? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.link_list_layout)

        insertValueInList(1)
        insertValueInList(2)
        insertValueInList(3)
        insertValueInList(4)
        insertValueInList(5)

        displayElement(mHead)
    }

    inner class NodeClass(data: Int?) {
        var data: Int? = null
        var next: NodeClass? = null

        init {
            this.data = data
            next = null
        }
    }

    private fun getNode(value: Int): NodeClass = NodeClass(value)

    private fun insertValueInList(value: Int) {
        if (mHead == null) {
            mHead = getNode(value)
            mLastHead = mHead
            mHashMap?.put(value, mHead!!)
        } else {
            if (mHashMap?.size!! < 4) {
                val mTempNode = getNode(value)
                mLastHead?.next = mTempNode
                mLastHead = mLastHead?.next
                mHashMap?.put(value, mTempNode)

            } else {
                mHashMap!!.remove(mHead!!.data)
                mHead = mHead!!.next
                val mTempNode = getNode(value)
                mLastHead?.next = mTempNode
                mHashMap?.put(value, mTempNode)

            }
        }
    }


    private fun displayElement(tempHead: NodeClass?) {
        val textValue = StringBuilder()
        var tempHead: NodeClass? = tempHead
        while (tempHead != null) {
            textValue.append(tempHead.data)
            textValue.append("-")
            tempHead = tempHead.next
        }
        Log.e("LIST IS :- ", "" + textValue.toString())
        (findViewById<View>(R.id.displayElement) as TextView).text = textValue.toString()
    }

}
