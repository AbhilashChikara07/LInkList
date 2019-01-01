package com.example.chikara.linklist.Question

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.chikara.linklist.R

class FlattenLinkList : AppCompatActivity() {
    var head: MergeShort.NodeClass? = null
    var tempHead: MergeShort.NodeClass? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.link_list_layout)

        val mLinkedList = LinkedList()
        mLinkedList.insertFunction()

    }

    class LinkedList {
        var head: Node? = null  // head of list

        /* Linked list Node*/
        class Node(var data: Int) {
            var right: Node? = null
            var down: Node? = null

            init {
                right = null
                down = null
            }
        }

        private fun merge(a: Node?, b: Node?): Node? {
            if (a == null) return b

            if (b == null) return a

            val result: Node

            if (a.data < b.data) {
                result = a
                result.down = merge(a.down, b)
            } else {
                result = b
                result.down = merge(a, b.down)
            }

            return result
        }

        private fun flatten(root: Node?): Node? {
            var root = root
            if (root == null || root.right == null)
                return root

            root.right = flatten(root.right)

            root = merge(root, root.right)

            return root
        }

        private fun push(head_ref: Node?, data: Int): Node {
            var head_ref = head_ref
            val new_node = Node(data)
            new_node.down = head_ref

            head_ref = new_node

            return head_ref
        }

        private fun printList() {
            var temp = head
            while (temp != null) {
                print(temp.data.toString() + " ")
                temp = temp.down
            }
            println()
        }

        fun insertFunction() {
            val L = LinkedList()

            /* Let us create the following linked list
        5 -> 10 -> 19 -> 28
        |    |     |     |
        V    V     V     V
        7    20    22    35
        |          |     |
        V          V     V
        8          50    40
        |                |
        V                V
        30               45
        */

            L.head = L.push(L.head, 30)
            L.head = L.push(L.head, 8)
            L.head = L.push(L.head, 7)
            L.head = L.push(L.head, 5)

            L.head!!.right = L.push(L.head!!.right, 20)
            L.head!!.right = L.push(L.head!!.right, 10)

            L.head!!.right!!.right = L.push(L.head!!.right!!.right, 50)
            L.head!!.right!!.right = L.push(L.head!!.right!!.right, 22)
            L.head!!.right!!.right = L.push(L.head!!.right!!.right, 19)

            L.head!!.right!!.right!!.right = L.push(L.head!!.right!!.right!!.right, 45)
            L.head!!.right!!.right!!.right = L.push(L.head!!.right!!.right!!.right, 40)
            L.head!!.right!!.right!!.right = L.push(L.head!!.right!!.right!!.right, 35)
            L.head!!.right!!.right!!.right = L.push(L.head!!.right!!.right!!.right, 28)

            // flatten the list
            L.head = L.flatten(L.head)

            L.printList()

        }

    }
}