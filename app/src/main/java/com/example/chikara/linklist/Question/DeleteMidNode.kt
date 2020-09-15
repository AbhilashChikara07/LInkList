package com.example.chikara.linklist.Question

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.TextView
import com.example.chikara.linklist.R

class DeleteMidNode : AppCompatActivity() {

    var head: NodeClass? = null
    var tempHead: NodeClass? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.link_list_layout)
        makeList()
        removeMidNode()
        displayElement()
    }

    inner class NodeClass(var tempValue: Int) {
        var data: Int? = null
        var next: NodeClass? = null

        init {
            this.data = tempValue
            next = null
        }
    }

    fun makeList() {

        insertionElement(1)
        insertionElement(2)
        insertionElement(3)
        insertionElement(4)
        insertionElement(3)
        insertionElement(2)
        insertionElement(1)

    }

    private fun insertionElement(tempValue: Int) {
        if (head == null) {
            head = NodeClass(tempValue)
            tempHead = head
        } else {
            val tempHead = NodeClass(tempValue)
            this.tempHead!!.next = tempHead
            this.tempHead = tempHead
        }
    }

    private fun removeMidNode() {
        var slow = head
        var temp = slow
        var fast = head?.next

        while (null != fast) {
            temp = slow
            slow = slow!!.next
            fast = fast.next?.next
        }

        temp!!.next = slow!!.next
        slow.next = null
    }

    private fun displayElement() {
        val textValue = StringBuilder()
        var tempHead: NodeClass? = head
        while (tempHead != null) {
            textValue.append(tempHead.data)
            tempHead = tempHead.next
        }
        (findViewById<View>(R.id.displayElement) as TextView).text = textValue.toString()
    }

}

