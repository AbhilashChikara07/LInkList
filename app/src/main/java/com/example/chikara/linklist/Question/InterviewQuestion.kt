package com.example.chikara.linklist.Question

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import android.widget.TextView
import com.example.chikara.linklist.R

/**
 * Created by chikara on 1/10/18.
 */

class InterviewQuestion : AppCompatActivity() {

    var head: NodeClass? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.link_list_layout)
        makeList()
        displayElement()
        printMidNode()
        printLatNthNodeUsingFstSlowPointer(4)
        printLatNthNode(3)
    }

    inner class NodeClass(var tempValue: Int) {
        var value: Int? = null
        var next: NodeClass? = null

        init {
            this.value = tempValue
            next = null
        }
    }

    fun makeList() {
        for (i in 0..99) {
            insertionElement(i)
        }
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


    private fun displayElement() {
        val textValue = StringBuilder()
        var tempHead: NodeClass? = head
        while (tempHead != null) {
            textValue.append(tempHead.value)
            tempHead = tempHead.next
        }
        (findViewById<View>(R.id.displayElement) as TextView).text = textValue.toString()
    }


    private fun printMidNode() {
        var slowPointer = head
        var fastPointer = head
        while (fastPointer != null && fastPointer.next != null) {
            fastPointer = fastPointer.next!!.next
            slowPointer = slowPointer!!.next
        }
        Log.e("mid node is :- ", "" + slowPointer!!.value)
    }

    /*
* Print nth node from last.
* To solve this :-
* 1- Calculate the length of Linked List. Let the length be len.
* 2- Print the (len – n + 1)th node from the starting of the Linked List.
* */

    private fun printLatNthNodeUsingFstSlowPointer(lastNodeNo: Int) {
        var fastNode: NodeClass? = head
        var slowNode: NodeClass? = head
        var count: Int? = 0
        while (count!! < lastNodeNo) {
            if (fastNode == null) {
                Log.e("List Status :- ", "List is empty")
            } else {
                fastNode = fastNode.next
                count += 1
            }
        }
        while (fastNode != null) {
            fastNode = fastNode.next
            slowNode = slowNode?.next
        }
        Log.e("Last Node Is :- ", "" + slowNode?.value)
    }

    private fun printLatNthNode(lastNodeNo: Int) {
        var count = 0
        var tempNode: NodeClass? = head
        if (lastNodeNo > getTotalNode()!! - lastNodeNo) {
            (findViewById<View>(R.id.displayElement) as TextView).text =
                    "Link List Have Limited Element"
        } else {
            while (count != getTotalNode()!! - lastNodeNo) {
                count += 1
                tempNode = tempNode?.next
            }
            Log.e("nth node value", "" + tempNode?.value)
        }
    }

    fun getTotalNode(): Int? {
        var tempNode: NodeClass? = head
        var count: Int? = 0
        while (tempNode != null) {
            tempNode = tempNode.next
            count = count!! + 1
        }
        return count
    }


    /*
    * Find that Link List have loop
    * */


}
