package com.example.chikara.linklist.Question

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.chikara.linklist.R

class DeleteNodesWhichHaveGreaterValueOnRightSide : AppCompatActivity() {
    private var head: NodeClass? = null
    private var tempHead: NodeClass? = null
    private var array = arrayOf(3, 2, 6, 5, 11, 10, 15, 12)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.link_list_layout)

        createNode(12)
        createNode(15)
        createNode(10)
        createNode(11)
        createNode(5)
        createNode(6)
        createNode(2)
        createNode(3)

        getRightList()
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

    private fun getRightList() {
        val tempArray: ArrayList<Int> = ArrayList()
        array.reverse()
        var prev = array[0]
        for (i in 1 until array.size) {
            if (prev < array[i]) {
                tempArray.add(array[i])
            }
            prev = array[i]
        }
        tempArray
    }

}