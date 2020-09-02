package com.example.chikara.linklist.Question

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.example.chikara.linklist.R

class Demo : AppCompatActivity() {
    private var mHead_1: NodeClass? = null
    private var mTempHead_1: NodeClass? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.link_list_layout)

        createNode(1)
        createNode(2)
        createNode(3)
        createNode(4)
        createNode(4)
        createNode(5)
        createNode(6)
        createNode(7)

        middleNode()
    }

    val map = HashMap<Int, Int>()

    class NodeClass(value: Int) {
        var mNext: NodeClass? = null
        var mValue: Int? = null

        init {
            this.mValue = value
            this.mNext = null
        }

    }

    private fun createNode(value: Int) {
        if (null == mHead_1) {
            mHead_1 = NodeClass(value)
            mHead_1!!.mNext = null
            mTempHead_1 = mHead_1
        } else {
            val mTempNode = NodeClass(value)
            mTempHead_1!!.mNext = mTempNode
            mTempHead_1 = mTempNode
        }
    }

    private fun middleNode() {
        var node = mHead_1
        while (null != node) {
            if (map.containsKey(node.mValue)) {
                var value = map[node.mValue!!] as Int
                value += 1
                map[node.mValue!!] = value
            } else {
                map[node.mValue!!] = 1
            }
            node = node.mNext
        }
        map
    }

}