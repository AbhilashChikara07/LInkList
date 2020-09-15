package com.example.chikara.linklist.Question

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.TextView
import com.example.chikara.linklist.R

// L0 -> Ln -> L1 -> Ln-1 -> L2 -> Ln-2 …
class RearrangeAGivenLinkedListInPlace : AppCompatActivity() {
    private var head: NodeClass? = null
    private var tempHead: NodeClass? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.link_list_layout)

        createNode(3)
        createNode(2)
        createNode(6)
        createNode(5)
        createNode(11)

        reArrangeLinkList()
    }

    class NodeClass(value: Int) {
        var next: NodeClass? = null
        var value: Int? = null

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
            val mTempNode = NodeClass(value)
            tempHead!!.next = mTempNode
            tempHead = mTempNode
        }
    }

    /*
    * First divide a list with middle.
    * Second reverse the second list.
    * Third link First list node with second list first node.
    * */
    private fun reArrangeLinkList() {
        var slow = head
        var fast = head!!.next
        var firstList = head
        var secondList: NodeClass? = null
        while (null != fast) {
            slow = slow!!.next
            fast = fast.next?.next
        }
        secondList = slow!!.next
        slow.next = null
        secondList = getReverseList(secondList)

        val tempHead = firstList
        while (null != firstList && null!=secondList) {
            fast = firstList.next
            firstList.next = NodeClass(secondList.value!!)
            firstList = firstList.next
            firstList?.next = fast
            secondList = secondList.next
        }
        displayElement(tempHead)
    }

    private fun getReverseList(tempHead: NodeClass?): NodeClass? {
        var current = tempHead
        var slow: NodeClass? = null
        var fast: NodeClass? = null

        while (null != current) {
            fast = current.next
            current.next = slow
            slow = current
            current = fast
        }
        return slow!!
    }

    private fun displayElement(mHead_1: NodeClass?) {
        val textValue = StringBuilder()
        var tempHead: NodeClass? = mHead_1
        while (tempHead != null) {
            textValue.append(tempHead.value)
            textValue.append(",")
            tempHead = tempHead.next
        }
        (findViewById<View>(R.id.displayElement) as TextView).text = textValue.toString()
    }

}