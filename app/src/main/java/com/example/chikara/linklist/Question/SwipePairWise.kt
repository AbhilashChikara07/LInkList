package com.example.chikara.linklist.Question

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.chikara.linklist.R

class SwipePairWise : AppCompatActivity() {

    var head: NodeClass? = null
    var tempHead: NodeClass? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.link_list_layout)

        for (i in 6 downTo 0)
            makeList(i)

        swipePairWise(head = head!!)
    }

    class NodeClass {
        var next: NodeClass? = null
        var data: Int? = null
    }

    private fun makeList(data: Int) {
        if (null == head)
            head = getNode(data)
        else {
            val tempNode = getNode(data)
            tempNode.next = head
            head = tempNode
        }

    }

    private fun getNode(data: Int): NodeClass {
        val tempNode = NodeClass()
        tempNode.data = data
        tempNode.next = null
        return tempNode
    }

    private fun swipePairWise(head: NodeClass) {
        var current = head
        while (current?.next != null) {
            val k = current.data
            current.data
            current.data = current.next!!.data
            current.next!!.data = k
            current = current.next!!.next!!
        }
        head
    }
}