package com.example.chikara.linklist.Question

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.TextView
import com.example.chikara.linklist.R

/**
 * Created by abhilash on 19/1/18.
 */

class DeleteUnshortListDupElementHashing : AppCompatActivity() {

    var head: NodeClass? = null
    var linkMap: HashMap<Int, Int> = HashMap()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.link_list_layout)
        makeList()
    }

    inner class NodeClass(var tempData: Int) {
        var data: Int? = null
        var next: NodeClass? = null

        init {
            this.data = tempData
            next = null
        }
    }

    fun makeList() {
        insertionElement(1)
        insertionElement(1)
        insertionElement(3)
        insertionElement(3)
        insertionElement(5)
        insertionElement(2)
        insertionElement(1)
        insertionElement(1)

        deleteUnshortList()
    }

    private fun insertionElement(tempValue: Int) {
        if (head == null) {
            head = NodeClass(tempValue)
        } else {
            val tempHead = NodeClass(tempValue)
            tempHead.next = head
            head = tempHead
        }
    }

    fun deleteUnshortList() {
        var slowNode = head
        var fastNode = head

        if (fastNode != null) {
            if (fastNode.next != null) {
                fastNode = fastNode.next
            }
        }
        linkMap[slowNode!!.data!!] = slowNode.data!!
        while (fastNode != null) {
            if (linkMap[fastNode.data!!] == fastNode.data) {
                fastNode = fastNode.next
                slowNode!!.next = null
                slowNode.next = fastNode
            } else {
                linkMap[fastNode.data!!] = fastNode.data!!
                fastNode = fastNode.next
                slowNode = slowNode!!.next
            }
        }
        displayElement()
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