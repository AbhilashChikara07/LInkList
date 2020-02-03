package com.example.chikara.linklist.Question

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import java.lang.StringBuilder

class MergeTwoListOnAlteration : AppCompatActivity() {

    var head: NodeClass? = null
    var secondHead: NodeClass? = null
    var count = 0

    var shortList: NodeClass? = null
    var tempHead: NodeClass? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        head = NodeClass().getLinkedList()
        secondHead = NodeClass().getSecondLinkList()

        mergeTwoListOnAlteration()
    }

    private fun mergeTwoListOnAlteration() {
        tempHead = head
        head = head!!.next
        shortList = tempHead

        while (null != head && null != secondHead) {
            if (count % 2 == 0) {
                tempHead!!.next = secondHead
                secondHead = secondHead!!.next
                tempHead = tempHead!!.next
            } else {
                tempHead!!.next = head
                head = head!!.next
                tempHead = tempHead!!.next
            }

            count += 1
        }
        if (null == head)
            shortList!!.next = secondHead
        else
            shortList!!.next = head

        displayListValues()
    }

    private fun displayListValues() {
        val stringBuilder = StringBuilder()

        while (shortList != null) {
            stringBuilder.append("" + shortList!!.data)
            shortList = shortList!!.next
        }

        Log.e("final-value", "" + stringBuilder)
    }

}