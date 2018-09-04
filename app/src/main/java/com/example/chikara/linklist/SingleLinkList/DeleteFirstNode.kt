package com.example.chikara.linklist.SingleLinkList

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.chikara.linklist.R

/**
 * Created by chikara on 12/29/17.
 */
class DeleteFirstNode : AppCompatActivity() {

    private var head: NodeClass? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.link_list_layout)
        makeLinkList()
        deleteFirstNode()
    }

    inner class NodeClass(value: Int) {
        var next: NodeClass? = null
        var value: Int? = null

        init {
            this.value = value
            next = null
        }
    }

    private fun makeLinkList() {
        for (i in 0..4) {
            insertionElement(i)
        }
    }

    private fun insertionElement(value: Int) {
        if (head == null)
            head = NodeClass(value)
        else {
            val tempNode = NodeClass(value)
            tempNode.next = head
            head = tempNode
        }
    }

    private fun deleteFirstNode() {
        val mTempNode = head
        head = head?.next
        mTempNode?.next = null
    }

}