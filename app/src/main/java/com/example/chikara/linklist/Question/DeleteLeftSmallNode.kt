package com.example.chikara.linklist.Question

import android.os.Bundle
import android.support.v7.app.AppCompatActivity

class DeleteLeftSmallNode : AppCompatActivity() {
    var head: NodeClass? = null

    private fun createLinkedList(value: Int) {
        if (null == head) {
            head = NodeClass()
            head!!.data = value
            head!!.next = null
        } else {
            val tempHead = NodeClass()
            tempHead.data = value
            tempHead.next = null
            tempHead.next = head
            head = tempHead
        }
    }

    inner class NodeClass {
        var next: NodeClass? = null
        var data: Int? = null
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        createLinkedList(3)
        createLinkedList(2)
        createLinkedList(6)
        createLinkedList(5)
        createLinkedList(11)
        createLinkedList(10)
        createLinkedList(15)
        createLinkedList(12)

        deleteLeftGreaterNode()
    }

    private fun deleteLeftGreaterNode() {
        var current = head
        var slow = current
        current = current!!.next
        var tempHead: NodeClass? = null
        var tempList:NodeClass? = null

        while (current != null) {
            if (current.data!! > slow!!.data!!) {
                if (null == tempHead){
                    tempHead = current
                    tempList = tempHead
                }
                else {
                    tempList!!.next = current
                    tempList = tempList.next
                }
            }
            current = current.next
            slow = slow.next
        }

        tempHead
    }

}

