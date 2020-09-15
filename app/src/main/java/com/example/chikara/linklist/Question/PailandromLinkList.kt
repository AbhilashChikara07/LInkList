package com.example.chikara.linklist.Question

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.example.chikara.linklist.R

/**
 * Created by abhilash on 18/1/18.
 */

/*
*
* */

class PailandromLinkList : AppCompatActivity() {

    var head: NodeClass? = null
    var tempHead: NodeClass? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.link_list_layout)
        makeList()
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

        findMidNode()
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


    private fun findMidNode() {
        var fastNode: NodeClass? = head
        var slowNode: NodeClass? = head

        while (fastNode!!.next !== null && fastNode != null) {
            slowNode = slowNode!!.next
            fastNode = fastNode.next!!.next
        }

        /*
        * To check rest length is even or not we have two methods.
        * */

        /*
        * METHOD -1
        * */
        if (fastNode!!.next == null)
            removeMidNode(slowNode)
        else {
            fastNode = slowNode
            reverseList(fastNode)

        }

        /*
        * METHOD -2
        * */

        if (!isEven(slowNode)) {
            removeMidNode(slowNode)
        } else {
            fastNode = slowNode
            reverseList(fastNode)
        }

    }

    private fun removeMidNode(tempList: NodeClass?) {
        val slowNode = tempList
        var secondListHead = tempList

        secondListHead = secondListHead!!.next
        slowNode!!.next = null

        reverseList(secondListHead)
    }


    private fun reverseList(tempList: NodeClass?) {
        var currentNode: NodeClass? = tempList
        var slowNode: NodeClass? = null
        var fastNode: NodeClass? = null

        while (currentNode != null) {
            fastNode = currentNode.next
            currentNode.next = slowNode
            slowNode = currentNode
            currentNode = fastNode
        }

        checkIsPailondromOrNot(slowNode!!)
    }


    private fun checkIsPailondromOrNot(secondList: NodeClass) {

        var pNode = head
        var qNode = secondList

        while (pNode != null && qNode != null) {
            if (pNode.data != qNode.data) {
                Log.e("ListStatus:-", "List Is Not Pailondrom")
            } else {
                Log.e("nodeDatas :-", "" + pNode.data + " -- " + qNode.data)
                pNode = pNode.next!!
                if (qNode.next == null) {
                    break
                } else
                    qNode = qNode.next!!
            }
        }
    }

    private fun isEven(slowNode: NodeClass? = null): Boolean {
        var count: Int? = 0
        var tempHead = slowNode
        while (tempHead != null) {
            count = count!! + 1
            tempHead = tempHead.next
        }
        return count!! % 2 == 0
    }

}