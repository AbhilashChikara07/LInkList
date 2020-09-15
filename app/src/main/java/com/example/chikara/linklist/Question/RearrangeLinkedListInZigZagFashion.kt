package com.example.chikara.linklist.Question

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.TextView
import com.example.chikara.linklist.R

class RearrangeLinkedListInZigZagFashion : AppCompatActivity() {
    private var head: NodeClass? = null
    private var tempHead: NodeClass? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.link_list_layout)

        createNode(1)
        createNode(2)
        createNode(3)
        createNode(4)
        createNode(5)
        createNode(6)

        createList()
    }

    class NodeClass(data: Int) {
        var next: NodeClass? = null
        var data: Int? = null

        init {
            this.data = data
            this.next = null
        }
    }

    private fun createNode(data: Int) {
        if (null == head) {
            head = NodeClass(data)
            tempHead = head
        } else {
            val mTempNode = NodeClass(data)
            tempHead!!.next = mTempNode
            tempHead = mTempNode
        }
    }

    private fun createList() {
        var currentNode = head
        var flag = true
        while (currentNode?.next != null) {
            if (flag) {
                if (currentNode.data!!.toInt() > currentNode.next?.data!!.toInt()) {
                    val temp = currentNode.data;
                    currentNode.data = currentNode.next?.data;
                    currentNode.next?.data = temp;
                }
            } else {
                if (currentNode.data!!.toInt() < currentNode.next?.data!!.toInt()) {
                    val temp = currentNode.data;
                    currentNode.data = currentNode.next?.data;
                    currentNode.next?.data = temp;
                }
            }

            currentNode = currentNode.next
            flag = !(flag)
        }

        displayElement(head)
    }

    private fun displayElement(mHead_1: NodeClass?) {
        val textValue = StringBuilder()
        var tempHead: NodeClass? = mHead_1
        while (tempHead != null) {
            textValue.append(tempHead.data)
            textValue.append(",")
            tempHead = tempHead.next
        }
        (findViewById<View>(R.id.displayElement) as TextView).text = textValue.toString()
    }

}