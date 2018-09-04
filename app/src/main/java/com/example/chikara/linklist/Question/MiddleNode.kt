package com.example.chikara.linklist.Question

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.example.chikara.linklist.R

class MiddleNode : AppCompatActivity() {


    var head: NodeClass? = null
    var tempHead: NodeClass? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.link_list_layout)
        makeLinkList()
        middleNode()
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

    private fun middleNode() {
        var fastNode = head
        var slowNode = head

        while (fastNode != null || fastNode?.next != null) {
            slowNode = slowNode?.next
            fastNode = fastNode.next?.next
        }

        Log.e("MIDDLE NODE IS :- ", "" + slowNode!!.value)

    }

}