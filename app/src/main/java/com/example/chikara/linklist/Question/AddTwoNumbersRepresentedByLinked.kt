package com.example.chikara.linklist.Question

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.chikara.linklist.R

class AddTwoNumbersRepresentedByLinked : AppCompatActivity() {
    private var head_1: NodeClass? = null
    private var head_2: NodeClass? = null
    private var tempHead_1: NodeClass? = null
    private var tempHead_2: NodeClass? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.link_list_layout)

        createNode_1(9)
        createNode_1(10)

        createNode_2(6)
        createNode_2(5)

        getSum()
    }

    class NodeClass(value: Int) {
        var next: NodeClass? = null
        var value: Int? = null

        init {
            this.value = value
            this.next = null
        }
    }

    private fun createNode_1(value: Int) {
        if (null == head_1) {
            head_1 = NodeClass(value)
            tempHead_1 = head_1
        } else {
            val mTempNode = NodeClass(value)
            tempHead_1!!.next = mTempNode
            tempHead_1 = mTempNode
        }
    }

    private fun createNode_2(value: Int) {
        if (null == head_2) {
            head_2 = NodeClass(value)
            tempHead_2 = head_2
        } else {
            val mTempNode = NodeClass(value)
            tempHead_2!!.next = mTempNode
            tempHead_2 = mTempNode
        }
    }


    private fun getSum() {
        var tempHead_1: NodeClass? = getReverseList(head_1!!)
        var tempHead_2: NodeClass? = getReverseList(head_2!!)
        val stringBuilder = StringBuilder()
        var carryValue = 0
        var tempValue = 0

        while (null != tempHead_1 && null != tempHead_2) {
            val value = tempHead_1.value!!.plus(tempHead_2.value!!).plus(carryValue)
            carryValue = value / 10
            tempValue = value % 10
            tempHead_1 = tempHead_1.next
            tempHead_2 = tempHead_2.next
            stringBuilder.append(tempValue)
        }

        if (0 != tempValue)
            stringBuilder.append(tempValue)

        if (null != tempHead_1) {
            while (null != tempHead_1) {
                stringBuilder.append(tempHead_1.value)
                tempHead_1 = tempHead_1.next
            }
        }

        if (null != tempHead_2) {
            while (null != tempHead_2) {
                stringBuilder.append(tempHead_2.value)
                tempHead_2 = tempHead_2.next
            }
        }


        stringBuilder

    }

    private fun getReverseList(tempHead: NodeClass?): NodeClass? {
        var slowNode: NodeClass? = null
        var fastNode: NodeClass? = null
        var current = tempHead
        try {
            while (null != current) {
                fastNode = current.next
                current.next = slowNode
                slowNode = current
                current = fastNode
            }
        } catch (ex: Exception) {
            ex.printStackTrace()
        }
        return slowNode
    }

}