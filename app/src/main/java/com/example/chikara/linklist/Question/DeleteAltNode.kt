package com.example.chikara.linklist.Question

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.TextView
import com.example.chikara.linklist.R

class DeleteAltNode : AppCompatActivity() {
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

        deleteAltNode()
    }

    class NodeClass(value: Int) {
        var next: NodeClass? = null
        var value: Int = 0

        init {
            this.value = value
            this.next = null
        }
    }

    private fun createNode(value: Int) {
        if (null == head) {
            head = NodeClass(value)
            tempHead = head
        } else {
            val node = NodeClass(value)
            tempHead?.next = node
            tempHead = tempHead!!.next
        }
    }

    private fun deleteAltNode() {
        var fast = head!!.next
        var slow = head

        while (null != fast) {
            slow!!.next = fast.next
            fast = fast.next?.next
            slow = slow.next
        }
        displayElement(head)
    }

    private fun displayElement(mHead: NodeClass?) {
        val textValue = StringBuilder()
        var tempHead: NodeClass? = mHead
        while (tempHead != null) {
            textValue.append(tempHead.value)
            tempHead = tempHead.next
        }
        (findViewById<View>(R.id.displayElement) as TextView).text = textValue.toString()
    }

}