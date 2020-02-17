package com.example.chikara.linklist.Question

import android.os.Bundle
import android.support.v7.app.AppCompatActivity

/**
 * By using stack we can solve this problem.
 * */
class ReverseLinkListInGroup : AppCompatActivity() {

    var head: NodeClass? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        makeLinkedList(6)
        makeLinkedList(5)
        makeLinkedList(4)
        makeLinkedList(3)
        makeLinkedList(2)
        makeLinkedList(1)

        reverseInGroup(3)
    }

    private fun makeLinkedList(item: Int) {
        val tempNode = NodeClass()
        tempNode.data = item
        tempNode.next = null
        if (null == head)
            head = tempNode
        else {
            tempNode.next = head
            head = tempNode
        }
    }

    class NodeClass {
        var data: Int? = null
        var next: NodeClass? = null
    }

    private fun reverseInGroup(group: Int): NodeClass? {
        return null
    }
}