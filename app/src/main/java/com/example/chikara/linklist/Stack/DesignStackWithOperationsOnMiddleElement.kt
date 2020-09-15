package com.example.chikara.linklist.Stack

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.TextView
import com.example.chikara.linklist.R

class DesignStackWithOperationsOnMiddleElement : AppCompatActivity() {

    var head: NodeClass? = null
    var tempHead: NodeClass? = null

    inner class NodeClass(data: Int) {
        var data: Int? = null
        var next: NodeClass? = null

        init {
            this.data = data
            this.next = null
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.link_list_layout)
        pushData(1)
        pushData(2)
        pushData(3)
        pushData(4)
        pushData(5)
        popData()
        getMiddleNode()
    }

    private fun createList(data: Int) {
        if (null == head) {
            head = NodeClass(data)
            tempHead = head
        } else {
            tempHead!!.next = NodeClass(data)
            tempHead = tempHead!!.next
        }
    }

    private fun pushData(data: Int) {
        createList(data)
    }

    private fun popData() {
        var slow = head
        var fast = head!!.next

        while (null != fast?.next) {
            slow = slow?.next
            fast = fast.next
        }
        val deleteNode = slow?.next
        findViewById<TextView>(R.id.displayElement).text = "Delete Node is :- " + deleteNode?.data
        slow?.next = null
    }

    private fun getMiddleNode() {
        var slow = head
        var mid = head
        var fast = head

        while (null != fast) {
            slow = mid
            mid = mid?.next
            fast = fast.next?.next
        }
        findViewById<TextView>(R.id.displayElement).text = "Middle Node is :- " + mid?.data

    }

}